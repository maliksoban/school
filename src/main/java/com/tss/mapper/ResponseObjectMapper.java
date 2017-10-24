package com.tss.mapper;


import com.tss.common.ResponseObject;

public class ResponseObjectMapper {

    private ResponseObjectMapper() {
    }

    public static ResponseObject convertResponseObjectMapperList(String status, String message, Object object) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus(status);
        responseObject.setMessage(message);
        responseObject.setObject(object);
        return responseObject;
    }
}
