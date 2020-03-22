package com.jav.service;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.jav.service.response.GetBicResponse;

@JsonRpcService("/resolver")
public interface BankDetailsResolution {
    GetBicResponse getBic(@JsonRpcParam(value = "") String iban);
}
