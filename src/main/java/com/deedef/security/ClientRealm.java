package com.deedef.security;

import com.deedef.Constante.ConstantStatus;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class ClientRealm extends AuthenticatingRealm {


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ClientToken;
    }

    private static String getPasswordByUsername(String username){
        // Les mot des passe sont stockés crypté et renversé
        String now = new SimpleDateFormat("yyyyMMdd").format(new Date());

        return new Sha256Hash(ConstantStatus.SALT+"|"+now+username).toString();
    }
    private void checkNotNull(Object reference, String message) {
        if (reference == null) {
            throw new AuthenticationException(message);
        }
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        ClientToken upToken = (ClientToken) authenticationToken;

        String username = upToken.getUsername();
        checkNotNull(username, "Null usernames are not allowed by this realm.");

        String password = getPasswordByUsername(username);
        checkNotNull(password, "No account found for user [" + username + "]");

        return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
    }
}
