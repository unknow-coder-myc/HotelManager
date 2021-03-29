package com.example.hotelManager.util;

public class PageUtil {
    public static long getMaxPageNum(long Num,int PageSize)
    {
        if(Num%PageSize!=0)
        {
        return Num/PageSize+1;
    }
        else{
        return Num/PageSize;
        }
    }
}
