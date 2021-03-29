package com.example.hotelManager.util;

import org.junit.jupiter.api.Test;


import java.security.MessageDigest;
import java.util.Base64;

public class StringHandle
{
    public static String byteArrayToString(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for(int i=0;i<b.length;i++)
        {
            resultSb.append(byteToNumString(b[i]));
        }
        return resultSb.toString();
    }
    public static String byteToNumString(byte b)
    {
        int _b = b;
        if(_b<0)
        {
            _b=256+_b;
        }
        return String.valueOf(_b);
    }
    public static String MD5Encode(String origin)
    {String resultString = null;
    try{
        resultString = new String(origin);
        MessageDigest md  = MessageDigest.getInstance("MD5");
        resultString = byteArrayToString(md.digest(resultString.getBytes()));

    }catch (Exception ex)
    {
        ex.printStackTrace();
    }
   return resultString;
    }

    @Test()
    public static void main(String args[])
    {
        System.out.println(StringHandle.MD5Encode(""));

    }
}
