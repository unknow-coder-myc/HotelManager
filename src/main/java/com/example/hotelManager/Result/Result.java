package com.example.hotelManager.Result;

public class Result<T>{

    /*
     *状态 Boolbean 成功返回true，失败返回false
     */
    private boolean success;
    /*
     *状态码，比如1000代表响应成功
     */
    private int code;
    /*
     *响应信息，用来说明响应情况
     */
    private String msg;
    /*
     *响应的具体数据
     */
    private T data;
    /*
    有页面的查询时，携带的最大页面数
     */
    private Long MaxPageNum;

    public Long getMaxPageNum() {
        return MaxPageNum;
    }

    public void setMaxPageNum(Long maxPageNum) {
        MaxPageNum = maxPageNum;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Result(int code)
    {
        this(true,code,"操作成功",null);
    }
    public Result(T data)
    {
        this(true,1000,"操作成功",data);
    }
    public Result(boolean success,int code,String msg,T data)
    {   this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;

    }
    public Result(boolean success,int code,String msg,T data,Long MaxPageNum)
    {   this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.MaxPageNum = MaxPageNum;

    }

}
