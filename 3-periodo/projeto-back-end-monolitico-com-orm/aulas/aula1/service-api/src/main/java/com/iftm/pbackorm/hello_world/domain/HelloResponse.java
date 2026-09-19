package com.iftm.pbackorm.hello_world.domain;

public class HelloResponse {
    private String timestamp;
    private String message;

    public HelloResponse(String timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
