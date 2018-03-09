package com.abel.encrypt;


import com.jcraft.jsch.JSch;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunzqc on 2017/7/7 14:02.
 * RAS Encryption
 */
public class MyRSA {
    private static final String KEY_ALGORITHM = "RSA";
    /**
     * 貌似默认是RSA/NONE/PKCS1Padding，未验证
     */
//    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String CIPHER_ALGORITHM = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String PUBLIC_KEY = "publicKey";
    private static final String PRIVATE_KEY = "privateKey";
    private static final String PUBLIC_KEY_FILE = "files/id_rsa.pub";
    private static final String PRIVATE_KEY_FILE = "files/id_rsa";
    /**
     * RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024
     */
    private static final int KEY_SIZE = 1024;
    private static final String PLAIN_TEXT = "MANUTD is the greatest club in the world";
    private static final String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZIWPCgfl30R+0CBMXmCsMIimvxummi9HZD50i" +
            "h5zi9R5LSyIVS4wiycT2gmDPNaQttp3Hkc36q90SdbuUHl/GmJ3YS6mZ/ADsz51sm4xc6QvS9DoW" +
            "QFtCTnsLLEeWH9HSAnw/ADD7K2K5aCMn29VUdSiXQa3uMtPphbDAtXQ5XwIDAQAB";
    private static final String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJkhY8KB+XfRH7QIExeYKwwiKa/G" +
            "6aaL0dkPnSKHnOL1HktLIhVLjCLJxPaCYM81pC22nceRzfqr3RJ1u5QeX8aYndhLqZn8AOzPnWyb" +
            "jFzpC9L0OhZAW0JOewssR5Yf0dICfD8AMPsrYrloIyfb1VR1KJdBre4y0+mFsMC1dDlfAgMBAAEC" +
            "gYEAgIdmFHzDx63fzlx4qfUvLKAAHWn387KoEGjqm3D4XgcfxlLp6LXgidKRX9dPKpz7kOMWy8u1" +
            "+BEJHdVz/H8CI4KuFkddK59BJF9MpQeYCO68dMj2m05/CuKgho/69p+CfCZPdTOBShOXbO4Rymoo" +
            "r2ex4CWWOemaRbsaDV6lPgECQQDMLPlI9KMiemLIOZSTwCUscE5Qmyyq0X3rFLB/0kL0hSavL/ad" +
            "YfQTd9cz0TnRMbMayfcAYqgStpMs7LaPsDnZAkEAv/+SqWk4/Q8V3cLWTFD7F99pNkH20InMRgI8" +
            "EUXJltrDQtzCfVyEPby2/avEEFu65ERhAI6W/erH4EmVuR0R9wJAFdrOiC+fcqZVAoefTr1nfT08" +
            "NMaXXmV0LACX7+aqwg+ql1/z7t64SIkwYNyJasn+GOT7anAk+3PNhyaDWBgN6QJAF5/a6/2GhZzV" +
            "k/Plan6MZuOWjpaPSBmsiPC9c2Ki62z/mbqQM9yuaOpPmecIuPqQhIXlaawh6Bx7e52STrTFAQJA" +
            "LuQ72Z8r2UymAi9vVUc5NaWH8lsJbNDh5gTdJLMGVEQkIkmrPPpRaCD7OslgbwgUy84P7u99wRvj" +
            "AGUtRSRN7g==";

    public static void main(String[] args) {
//        Map<String, byte[]> keyMap = generateKeyBytes();
//        System.out.println(Base64.encodeBase64String(keyMap.get(PUBLIC_KEY)));
//        System.out.println(Base64.encodeBase64String(keyMap.get(PRIVATE_KEY)));
//        outPutKeysToFile(keyMap);

        Map<String, byte[]> keyMap = getKeysMap();


        // 加密
        PublicKey publicKey = restorePublicKey(keyMap.get(PUBLIC_KEY));

        byte[] encodedText = RSAEncode(publicKey, PLAIN_TEXT.getBytes());
        assert encodedText != null;
        System.out.println("RSA encoded: " + Base64.encodeBase64String(encodedText));

        // 解密
        PrivateKey privateKey = restorePrivateKey(keyMap.get(PRIVATE_KEY));
        System.out.println("RSA decoded: "
                + RSADecode(privateKey, encodedText));

    }


    private static Map<String, byte[]> getKeysMap() {
        File publicKeyFile = new File(PUBLIC_KEY_FILE);
        File privateKeyFile = new File(PRIVATE_KEY_FILE);
        Map<String, byte[]> resultMap = new HashMap<>();
        char[] chars = new char[1024];

        try {
            StringBuilder stringBuilder = new StringBuilder();
            FileReader fileReader = new FileReader(new File(PUBLIC_KEY_FILE));
            while (fileReader.read(chars) != -1) {
                stringBuilder.append(chars);
            }
            System.out.println(stringBuilder.toString());
            resultMap.put(PUBLIC_KEY, Base64.decodeBase64(stringBuilder.toString()));
            fileReader.close();

            stringBuilder = new StringBuilder();
            fileReader = new FileReader(new File(PRIVATE_KEY_FILE));
            while (fileReader.read(chars) != -1) {
                stringBuilder.append(chars);
            }
            System.out.println(stringBuilder.toString());
            resultMap.put(PRIVATE_KEY, Base64.decodeBase64(stringBuilder.toString()));
            fileReader.close();
            return resultMap;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void outPutKeysToFile(Map<String, byte[]> keyPair) {

        File publicKeyFile = new File(PUBLIC_KEY_FILE);
        File privateKeyFile = new File(PRIVATE_KEY_FILE);

        try {
            FileWriter fileWriter = new FileWriter(publicKeyFile);
            fileWriter.write(Base64.encodeBase64String(keyPair.get(PUBLIC_KEY)));
            fileWriter.close();
            fileWriter = new FileWriter(privateKeyFile);
            fileWriter.write(Base64.encodeBase64String(keyPair.get(PRIVATE_KEY)));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 生成密钥对。注意这里是生成密钥对KeyPair，再由密钥对获取公私钥
     *
     * @return 秘钥对 map
     */
    private static Map<String, byte[]> generateKeyBytes() {

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                    .getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            Map<String, byte[]> keyMap = new HashMap<>();
            keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
            keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
     *
     * @param keyBytes 公钥byte
     * @return 公钥
     */
    private static PublicKey restorePublicKey(byte[] keyBytes) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);

        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            return factory.generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
     *
     * @param keyBytes 私钥byte
     * @return 私钥
     */
    private static PrivateKey restorePrivateKey(byte[] keyBytes) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                keyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            return factory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密，三步走。
     *
     * @param key       秘钥
     * @param plainText 内容
     * @return 加密byte
     */
    private static byte[] RSAEncode(PublicKey key, byte[] plainText) {

        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(plainText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 解密，三步走。
     *
     * @param key         私钥
     * @param encodedText 加密内容
     * @return 解密内容
     */
    private static String RSADecode(PrivateKey key, byte[] encodedText) {

        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(encodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 生成ssh公钥私钥
     *
     * @param comment 注释
     * @return 公钥私钥
     */
    public static Map<String, String> getKeyMap(String comment) {
        Map<String, String> keys = new HashMap<>();
        int type = com.jcraft.jsch.KeyPair.RSA;
        JSch jsch = new JSch();
        try {
            com.jcraft.jsch.KeyPair keyPair = com.jcraft.jsch.KeyPair.genKeyPair(jsch, type);
            //私钥
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//向OutPutStream中写入
            keyPair.writePrivateKey(byteArrayOutputStream);
            String privateKeyString = byteArrayOutputStream.toString();
            //公钥
            byteArrayOutputStream = new ByteArrayOutputStream();
            keyPair.writePublicKey(byteArrayOutputStream, comment);
            String publicKeyString = byteArrayOutputStream.toString();
            System.out.println("Finger print: " + keyPair.getFingerPrint());
            keyPair.dispose();
            // 得到公钥字符串
//          String publicKeyString = RSAEncrypt.loadPublicKeyByFile(filePath,filename + ".pub");
//          System.out.println(publicKeyString.length());
            System.out.println(publicKeyString);
            keys.put("publicKey", publicKeyString);
            // 得到私钥字符串
//          String privateKeyString = RSAEncrypt.loadPrivateKeyByFile(filePath,filename);
//          System.out.println(privateKeyString.length());
            System.out.println(privateKeyString);
            keys.put("privateKey", privateKeyString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keys;
    }
}
