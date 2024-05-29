package com.weatherapp.util;

public enum ConstantMessages {
    NOT_FOUND("Sorry! Cannot resolve weather information for the requested location.", 1),
    INTERNAL_ERROR("Internal Server Error.", 2);
    private String message;
    private int status;
    ConstantMessages(String message, int status){
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ConstantMessages{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
