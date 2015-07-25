package com.deedef.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by birame ndiaye on 26/05/2015.
 */
public class DbCredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        String tokenCredentials = charArrayToString(token.getCredentials());
//        //String reverseToken = StringUtils.reverse(tokenCredentials);
//        // String encryptedToken = new Sha256Hash(reverseToken).toString();
//        String encryptedToken = new Sha256Hash(tokenCredentials).toString();
//
//        String accountCredentials = charArrayToString(info.getCredentials());
//        return accountCredentials.equals(encryptedToken);

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
