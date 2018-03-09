package com.abel.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by sunzqc on 2017/7/7 12:23.
 * AES Encryption
 */
public class MyAES {

    private static final String KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String IV = "0314021704193130"; //使用CBC模式需要一个初始向量 cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec); EBC模式不需要
    private static final String userKey = "1234567890987654"; // 密码需要16位

    private static final Integer LENGTH_128 = 128;

    private static byte[] encrypt(String content, String userKey, Integer length) {
        try {

            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes("utf-8"));

            SecretKeySpec key = getSecretKeySpec(userKey, length);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            return cipher.doFinal(byteContent);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException | UnsupportedEncodingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKeySpec getSecretKeySpec(String userKey, Integer length) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//            由于每次SecureRandom 产生随机的key 解密时会出现异常
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(length, new SecureRandom(userKey.getBytes("utf-8")));
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        System.out.println(Base64.encodeBase64String(enCodeFormat) + "  |=============");
        System.out.println(enCodeFormat.length);
        return new SecretKeySpec(userKey.getBytes(), KEY_ALGORITHM);
//        return new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);

    }

    private static byte[] decrypt(byte[] content, String userKey, Integer length) throws UnsupportedEncodingException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            SecretKeySpec key = getSecretKeySpec(userKey, length);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);// 初始化
            return cipher.doFinal(content); // 加密
        } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | NoSuchPaddingException | IllegalBlockSizeException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void decryptFromFile(String srcFile, String destFile, String userKey) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            SecretKeySpec key = new SecretKeySpec(userKey.getBytes(), KEY_ALGORITHM);
            Cipher encryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
            encryptCipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);// 初始化
            BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));

            FileWriter decryptFileWriter = new FileWriter(destFile);
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                String tmpLine = new String(encryptCipher.doFinal(Base64.decodeBase64(strLine)), "utf-8");
                decryptFileWriter.write(tmpLine + "\n");
            }
            bufferedReader.close();
            decryptFileWriter.close();


        } catch (NoSuchAlgorithmException |
                InvalidKeyException |
                NoSuchPaddingException |
                InvalidAlgorithmParameterException |
                IOException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }


    private static void encryptFromFile(String srcFile, String destFile, String userKey) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            SecretKeySpec key = new SecretKeySpec(userKey.getBytes(), KEY_ALGORITHM);
            Cipher encryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);// 初始化
            BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));

            FileWriter encryptFileWriter = new FileWriter(destFile);
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                String tmpLine = Base64.encodeBase64String(encryptCipher.doFinal(strLine.getBytes("utf-8")));
                encryptFileWriter.write(tmpLine + "\n");
            }
            bufferedReader.close();
            encryptFileWriter.close();


        } catch (NoSuchAlgorithmException |
                InvalidKeyException |
                NoSuchPaddingException |
                InvalidAlgorithmParameterException |
                IOException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }


    private static void decryptBinaryFile(String srcFile, String destFile, String userKey) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            SecretKeySpec key = new SecretKeySpec(userKey.getBytes(), KEY_ALGORITHM);
            Cipher encryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
            encryptCipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);// 初始化
            BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));

            OutputStream decryptFileWriter = new FileOutputStream(destFile);
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                decryptFileWriter.write(encryptCipher.doFinal(Base64.decodeBase64(strLine)));
            }
            bufferedReader.close();
            decryptFileWriter.close();


        } catch (NoSuchAlgorithmException |
                InvalidKeyException |
                NoSuchPaddingException |
                InvalidAlgorithmParameterException |
                IOException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    private static void encryptBinaryFile(String srcFile, String destFile, String userKey) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
            SecretKeySpec key = new SecretKeySpec(userKey.getBytes(), KEY_ALGORITHM);
            Cipher encryptCipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);// 初始化
            InputStream inputStream = new FileInputStream(srcFile);
            byte[] in = new byte[102400];
            FileWriter encryptFileWriter = new FileWriter(destFile);
            while (inputStream.read(in) != -1) {
                String tmpLine = Base64.encodeBase64String(encryptCipher.doFinal(in));
                encryptFileWriter.write(tmpLine + "\n");
            }
            encryptFileWriter.close();
            inputStream.close();


        } catch (NoSuchAlgorithmException |
                InvalidKeyException |
                NoSuchPaddingException |
                InvalidAlgorithmParameterException |
                IOException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String content = "love yyd!!";

        String userKey = "1234567890987654"; // 密码需要16位
//        System.out.println("加密前: " + content);
//
//        System.out.println("===============128==================");
//        byte[] enCryptResult = encrypt(content, userKey, LENGTH_128);
//        String hexString = Base64.encodeBase64String(enCryptResult);
//        System.out.println(hexString);
//        byte[] decryptResult = decrypt(Base64.decodeBase64(hexString), userKey, LENGTH_128);
//        assert decryptResult != null;
//        System.out.println("解密后：" + new String(decryptResult));
//        System.out.println("===============end==================");


        String enFileName = "files/encrypt.ppo";
        String deFileName = "files/decrypt.ppo";

//        encryptBinaryFile("/Users/fpschina/Downloads/993/993db.mp4", enFileName, userKey);
        decryptBinaryFile(enFileName, deFileName, userKey);


    }

}
