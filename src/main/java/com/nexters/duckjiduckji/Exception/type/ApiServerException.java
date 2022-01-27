package com.nexters.duckjiduckji.Exception.type;

public class ApiServerException extends RuntimeException{
    public ApiServerException(String roomId) {
        super(roomId);
    }
}
