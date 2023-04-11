package com.example.task.model.dto;

public class DefaultResponse<T> {
    private Boolean status;
    private T size;

    public String getMessage() {
        return message;
    }

    private T data;


    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
