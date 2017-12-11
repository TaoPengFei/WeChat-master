package com.weixin.po;

/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/15.
 *
 */
public class AccessToken {
    private String token;
    private int expiresIn;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}