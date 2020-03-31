package com.jav.request;

import lombok.Getter;

import java.util.List;

@Getter
public class JsonRpcRequest {
    String jsonrpc = "2.0";
    String id = "1";
    String method;
    List<String> params;

    public JsonRpcRequest(String method, List<String> params) {
        this.method = method;
        this.params = params;
    }
}
