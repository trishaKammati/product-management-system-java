package com.trisha.productapp.response;

import java.time.LocalDateTime;

public class ApiResponse {
    private int status;
    private String message;
    private Object data;
    private LocalDateTime timestamp;

    public ApiResponse(int status,String message,Object data){
        this.status=status;
        this.message=message;
        this.data=data;
        this.timestamp=LocalDateTime.now();

    }

    public static  ApiResponse success(Object data){
        return new ApiResponse(200,"Success",data);
    }

    public static ApiResponse created(Object data){
        return new ApiResponse(201,"Created Successfully",data);
    }

    public static ApiResponse deleted(){
        return new ApiResponse(200,"Deleted Successfully",null);
    }

    public static ApiResponse error(Object data){
        return new ApiResponse(404,"Created Successfully",data);
    }



    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
