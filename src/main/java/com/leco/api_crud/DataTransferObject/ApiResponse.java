package com.leco.api_crud.DataTransferObject;

public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    //define structure api response
    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //Get and Set
    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}
