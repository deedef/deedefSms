package com.deedef.security;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class ClientToken implements AuthenticationToken{
   private String type;
    private String username;
    private String salt;

    public String getType() {
        return type;
    }
public ClientToken(){

}
    public ClientToken(String username,String salt){
       this.username=username;
        this.salt=salt;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public Object getPrincipal() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return salt;
    }
}
