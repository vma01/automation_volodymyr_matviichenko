package utils;

import org.apache.commons.codec.binary.Base64;

public class HashCodeValue {
    private final static String HASH = "grant_type=client_credentials";

    public static String getEncodeHashCodeValue() {
        return Base64.encodeBase64String(HASH.getBytes());
    }

    public static String getDecodeHashValueCode(String encodeHash) {
        return Base64.decodeBase64(encodeHash).toString();
    }
}
