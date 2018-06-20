package com.zjs.del.common;

import java.io.Serializable;

public class BaseResp<T extends Object> implements Serializable {

    public static int SUCCESS = 0;

    public static int FAIlURE = -1;
 
    //成功直接返回 BaseResp.ok()
    public static BaseResp ok() {

        return new BaseResp(BaseResp.SUCCESS, "操作成功!");
    }
    //成功直接返回 BaseResp.ok(msg)
    public static BaseResp ok(String msg) {

        return new BaseResp(BaseResp.SUCCESS, msg);
    }

    //失败直接返回 BaseResp.fail()
    public static BaseResp fail() {

        return new BaseResp(BaseResp.FAIlURE, "服务器异常!");
    }

    //失败直接返回 BaseResp.fail(msg)
    public static BaseResp fail(String msg) {

        return new BaseResp(BaseResp.FAIlURE, msg);
    }

    private int code;

    private T data;

    private String description;

    private String downloadkey;

    private Boolean beRefresh;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    private long total;

    public BaseResp() {

    }

    public BaseResp(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public BaseResp(T data) {
        this.code = SUCCESS;
        this.data = data;
    }

    public Boolean getBeRefresh() {
        return beRefresh;
    }

    public void setBeRefresh(Boolean beRefresh) {
        this.beRefresh = beRefresh;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadkey() {
        return downloadkey;
    }

    public void setDownloadkey(String downloadkey) {
        this.downloadkey = downloadkey;
    }
}
