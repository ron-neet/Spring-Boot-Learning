package com.SpringClass.RestServices.rest;

public class StudentErrorResponse {

    private int httpStatus;
    private String message;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int httpStatus, String message, long timeStamp){
        this.httpStatus = httpStatus;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
    public String getMessage() {
        return message;
    }
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setHttpStatus(int httpStatus){
        this.httpStatus = httpStatus;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setTimeStamp(long timeStamp){
        this.timeStamp = timeStamp;
    }
}
