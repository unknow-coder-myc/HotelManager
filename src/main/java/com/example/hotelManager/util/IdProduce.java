package com.example.hotelManager.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdProduce {

    @Test()
    public static String InIDProduce()
    {  String InID;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result ="";
        Random random = new Random();
        for(int i = 0 ;i<3; i++)
        {result += random.nextInt(10); }
//        return "I"+newDate+result;
        return "I"+result;
    }
    public static String RandomIDProduce(String param)
//    {  String InID;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String newDate = sdf.format(new Date());

    { String result ="";
        Random random = new Random();
        for(int i = 0 ;i<7; i++)
        {result += random.nextInt(10); }
//        return "I"+newDate+result;
        return param+result;
    }
    public static String CustomerIDProduce(String CustomerIDNumber)
    {
        return CustomerIDNumber;
    }
    public static void main(String args[])
//    {System.out.println(IdProduce.InIDProduce());
    {
        Date date = new Date();
        System.out.println(date);
    }


}
