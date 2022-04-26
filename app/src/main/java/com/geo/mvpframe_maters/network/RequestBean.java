package com.geo.mvpframe_maters.network;

public class RequestBean<T> {


    private int code;
    private String message;
    private String dataType;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", dataType='" + dataType + '\'' +
                ", data=" + data +
                '}';
    }
}
