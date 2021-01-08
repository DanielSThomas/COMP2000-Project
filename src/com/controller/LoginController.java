package com.controller;

import com.model.Admin;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;


public class LoginController
{

   private Admin admin = new Admin();


    public Boolean Login(String _username, char[] _password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {


        //PBKDF2 Hashing without random salt

        KeySpec keySpec = new PBEKeySpec(_password,new byte[1],1998,128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
        Base64.Encoder encoder = Base64.getEncoder();


        if ( _username.equals(admin.getUsername()) && encoder.encodeToString(hash).equals(admin.getPassword()))
        {
            return true;
        }
        return false;

    }



}
