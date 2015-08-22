package com.deedef.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by birame ndiaye on 17/05/2015.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class Status {
    private String message;
    private Integer code;
    public Status(){

    }

    public Status(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
