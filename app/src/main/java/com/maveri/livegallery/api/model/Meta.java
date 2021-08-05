package com.maveri.livegallery.api.model;

public class Meta {

    private String msg;
    private Integer status;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setResponse_id(String response_id) {
        this.response_id = response_id;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getResponse_id() {
        return response_id;
    }

    private String response_id;

}
