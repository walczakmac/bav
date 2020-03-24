package com.jav.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.jav.presentation.response.IbanValidationResponse;

@JsonRpcService("/validator")
public interface IbanValidation {
    IbanValidationResponse validate(@JsonRpcParam(value = "") String iban);
}
