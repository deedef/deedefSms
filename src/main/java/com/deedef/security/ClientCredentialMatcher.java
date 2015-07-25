package com.deedef.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.StringUtils;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class ClientCredentialMatcher extends SimpleCredentialsMatcher {

        @Override
        public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
            String tokenCredentials = charArrayToString(token.getCredentials());
            String accountCredentials = charArrayToString(info.getCredentials());
            return  tokenCredentials.equals(accountCredentials);
}


    private String charArrayToString(Object credentials) {
        return new String((char[]) credentials);
    }
    private String encrypt(String password){
         return new Sha256Hash(password).toString();
    }
}
