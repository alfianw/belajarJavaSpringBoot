/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Hp
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    
    private String code;
    private String message;
    private T response;

    public Response(String code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public Response() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
    
    
    
}
