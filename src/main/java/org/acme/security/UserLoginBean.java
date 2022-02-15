package org.acme.security;

public class UserLoginBean {
    private String jwtToken;
    private String userId;
    private String userName;
    public String getJwtToken() {
        return jwtToken;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
