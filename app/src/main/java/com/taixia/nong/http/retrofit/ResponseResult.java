package com.taixia.nong.http.retrofit;

/**
 * Author:    valuesfeng
 * Version    V1.0
 * Date:      16/3/26
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/3/26          valuesfeng              1.0                    1.0
 * Why & What is modified:
 */
public class ResponseResult<T> {

    private int status;
    private T data;
    private String info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
