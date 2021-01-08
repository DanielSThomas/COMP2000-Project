package com.controller;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;


public class LoginController
{

    private String username = "admin";
    private String password = "CPMvT/pYiZyJwvTBF0ugcQ==";


    public Boolean Login(String _username, char[] _password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {

        //PBKDF2 Hashing without random salt

        KeySpec keySpec = new PBEKeySpec(_password,new byte[1],1998,128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
        Base64.Encoder encoder = Base64.getEncoder();

        System.out.println("Hash : " + encoder.encodeToString(hash));

        if ( _username.equals(username) && encoder.encodeToString(hash).equals(password))
        {
            return true;
        }
        return false;

    }



}
