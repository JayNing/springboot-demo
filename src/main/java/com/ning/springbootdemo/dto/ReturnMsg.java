package com.ning.springbootdemo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnMsg implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer errorCode;
    private List<String> errorMsg = new ArrayList<>();
    private Object data;

    public void addErrorMsg(String msg){
        this.errorMsg.add(msg);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnMsg{" +
                "errorCode=" + errorCode +
                ", errorMsg=" + errorMsg +
                ", data=" + data +
                '}';
    }
}