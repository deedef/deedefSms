package com.deedef.Constante;

/**
 * Created by birame ndiaye on 31/05/2015.
 */

//import com.google.common.io.BaseEncoding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Classe utilitaire de chargement de la clé secrete
 */
public class KeystoreUtil {
    private static final Logger LOG = LoggerFactory.getLogger(KeystoreUtil.class);

    public static Key getKeyFromKeyStore(final String keystoreLocation, final String keystorePass, final String alias, final String keyPass) {
        try {
            InputStream keystoreStream = new FileInputStream(keystoreLocation);
            KeyStore keystore = KeyStore.getInstance("JCEKS");
            keystore.load(keystoreStream, keystorePass.toCharArray());
            LOG.debug("Keystore with alias {} found == {}", alias, keystore.containsAlias(alias));
            if (!keystore.containsAlias(alias)) {
                throw new RuntimeException("Alias for key not found");
            }
            Key key = keystore.getKey(alias, keyPass.toCharArray());
            //LOG.debug("Key Found {} -> {}", key.getAlgorithm(), BaseEncoding.base64().encode(key.getEncoded()));
            return key;
        } catch (UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    // <SystemProperties>
    //   <javax.net.ssl.trustStore>${basedir}/../deedef/src/main/resources</javax.net.ssl.trustStore>
    //  <javax.net.ssl.trustStoreType></javax.net.ssl.trustStoreType>

    // </SystemProperties>
}