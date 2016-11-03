package com.taixia.nong.http.retrofit;

public class BaseValueInvalidException extends RuntimeException {

    private ResponseResult dataResponse;

    public BaseValueInvalidException(ResponseResult dataResponse) {
        super(dataResponse.getInfo());
        this.dataResponse = dataResponse;
    }

    public int getCode() {
        return dataResponse.getStatus();
    }

    public String getMessage() {
        return dataResponse.getInfo();
    }

    public ResponseResult getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(ResponseResult dataResponse) {
        this.dataResponse = dataResponse;
    }
}