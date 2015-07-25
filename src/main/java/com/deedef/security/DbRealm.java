package com.deedef.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class DbRealm extends AuthenticatingRealm {

   @Override
   public boolean supports(AuthenticationToken token) {
       return token instanceof DbToken;
   }

    private static String getPasswordByUsername(String username){
        // Les mot des passe sont stockés crypté et renversé
        return "111111";
    }
    private void checkNotNull(Object reference, String message) {
        if (reference == null) {
            throw new AuthenticationException(message);
        }
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        DbToken upToken = (DbToken) authenticationToken;

        String username = upToken.getUsername();
        checkNotNull(username, "Null usernames are not allowed by this realm.");

        String password = getPasswordByUsername(username);
        checkNotNull(password, "No account found for user [" + username + "]");

        return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
    }



}
