package com.jav.service.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jav.request.JsonRpcRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IbanValidatorIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @MethodSource("provideValidIbans")
    public void validateTest(String iban, String countryCode, String swiftBic) throws Exception {
        List<String> params = new ArrayList<>();
        params.add(iban);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/validator")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(new JsonRpcRequest("validate", params)));

        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result.errors").isEmpty())
            .andExpect(jsonPath("$.result.countryCode").value(countryCode))
            .andExpect(jsonPath("$.result.bicCode").value(swiftBic));
    }

    private static Stream<Arguments> provideValidIbans() {
        return Stream.of(
            Arguments.of("SE7780000827015041234641", "SE", "SWEDSESSXXX"),
            Arguments.of("DE97672500200009003452", "DE", "SOLADES1HDB"),
            Arguments.of("FR7614707000600602101819412", "FR", "CCBPFRPPMTZ"),
            Arguments.of("FR76147-07000600-6021018-19412", "FR", "CCBPFRPPMTZ"),
            Arguments.of("FR76147 07000600 6021018 19412", "FR", "CCBPFRPPMTZ"),
            Arguments.of("MA64022780000102000503075774", "MA", null),
            Arguments.of("BY31BLBB30120191670289001002", "BY", "BLBBBY2XXXX"),
            Arguments.of("UA213223130000026007233566001", "UA", "EXBSUAUXXXX")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidIbans")
    public void validateFailureTest(String iban, String error) throws Exception {
        List<String> params = new ArrayList<>();
        params.add(iban);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/validator")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(new JsonRpcRequest("validate", params)));

        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result.errors").value(error))
            .andExpect(jsonPath("$.result.countryCode").isEmpty())
            .andExpect(jsonPath("$.result.bicCode").isEmpty());
    }

    private static Stream<Arguments> provideInvalidIbans() {
        return Stream.of(
            Arguments.of("64022780000102000503075774", "Invalid checksum resolved from provided IBAN."),
            Arguments.of("SICOTHBK", "Invalid checksum resolved from provided IBAN."),
            Arguments.of("DE97672500200009003453", "Invalid checksum resolved from provided IBAN."),
            Arguments.of("UA21AAAA1300000260072335660012", "Invalid checksum resolved from provided IBAN."),
            Arguments.of("UA213223130000026007233566002", "Invalid checksum resolved from provided IBAN.")
        );
    }
}
