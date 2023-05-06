package eu.mshade.enderframe.protocol;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;

public class MinecraftEncryption {

    private KeyPair keyPair;

    public MinecraftEncryption() {
        try {
            KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA");
            keypairgenerator.initialize(1024);
            keyPair = keypairgenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public String getHashServerId(String s, PublicKey publickey, SecretKey secretkey) throws NoSuchAlgorithmException {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        messagedigest.update(s.getBytes());
        messagedigest.update(secretkey.getEncoded());
        messagedigest.update(publickey.getEncoded());
        return new BigInteger(messagedigest.digest()).toString(16);
    }

    public SecretKey getSecretKey(byte[] secretKeyEncrypted) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(this.keyPair.getPrivate().getAlgorithm());
        cipher.init(2, this.keyPair.getPrivate());
        return new SecretKeySpec(cipher.doFinal(secretKeyEncrypted), "AES");
    }

    public static Cipher getCipher(int i, SecretKey secretKey){
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher.init(i, secretKey, new IvParameterSpec(secretKey.getEncoded()));
            return cipher;
        } catch (GeneralSecurityException generalsecurityexception) {
            throw new RuntimeException(generalsecurityexception);
        }
    }

    public static SecretKey createNewSharedKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException var1) {
            throw new Error(var1);
        }
    }

}
