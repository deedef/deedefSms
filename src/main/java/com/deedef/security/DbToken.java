package com.deedef.security;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class DbToken extends UsernamePasswordToken {
    private String type;
    private Boolean isAuthenticated;
    public DbToken(){}
    public DbToken(String username, String password){
        super(username,password);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isAuthenticated() {
        if(isAuthenticated==null)
            return false;
        return isAuthenticated;
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}

