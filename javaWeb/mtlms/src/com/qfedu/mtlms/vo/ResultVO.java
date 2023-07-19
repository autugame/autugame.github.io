package com.qfedu.mtlms.vo;

/**
 * An object that responses to an ajax request.
 */
public class ResultVO {
    private int code;
    private String message;

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO() {
    }

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
}
