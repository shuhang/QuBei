package com.pku45a.difference.http;

import per.goweii.rxhttp.request.base.BaseResponse;

/**
 * @author CuiZhen
 * @date 2019/5/8
 * QQ: 302833254
 * E-mail: goweii@163.com
 * GitHub: https://github.com/goweii
 */
public class WanResponse<E> implements BaseResponse<E> {

    private int error_code;
    private String message;
    private E data;

    @Override
    public int getCode() {
        return error_code;
    }

    @Override
    public void setCode(int code) {
        this.error_code = code;
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public void setMsg(String msg) {
        message = msg;
    }
}
