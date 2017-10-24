package com.tss.common;

import java.io.Serializable;

public class ResponseObject implements Serializable {
    private static final long serialVersionUID = 5404034081148105127L;

    private String status;
    private String message;
    private transient Object object;

    public ResponseObject() {
    }

    public ResponseObject(String status) {
        this.status = status;
    }

    public ResponseObject(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseObject(String status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}