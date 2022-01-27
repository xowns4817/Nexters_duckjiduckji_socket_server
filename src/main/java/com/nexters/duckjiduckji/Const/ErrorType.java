package com.nexters.duckjiduckji.Const;

import lombok.RequiredArgsConstructor;

public enum ErrorType {
    API_SERVER_ERROR("501", "API SERVER ERROR"),
    SOCKET_SERVER_ERROR("502", "SOCKET SERVER ERROR");

    private String code;
    private String msg;

    ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
