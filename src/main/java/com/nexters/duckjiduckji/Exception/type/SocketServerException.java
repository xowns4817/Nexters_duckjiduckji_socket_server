package com.nexters.duckjiduckji.Exception.type;


public class SocketServerException extends RuntimeException {
    public SocketServerException(String roomId) {
        super(roomId);
    }
}
