package com.arthas.learningcurve.model;

import java.io.Serializable;

/**
 * Created by Tcz on 16/4/13.
 */
public class BaseModel implements Serializable{
    protected Integer code;
    protected String message;
    protected Token token;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
