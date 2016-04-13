package com.arthas.learningcurve.model;

/**
 * Created by Tcz on 16/4/13.
 */
public class Token {
    private String userId;
    private long loginTime;
    private String secretkey;

    public Token() {
    }

    public Token(String userId, long loginTime) {
        this.userId = userId;
        this.loginTime = loginTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
}
