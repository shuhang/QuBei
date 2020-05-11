package com.pku45a.difference.module.QB.Modal;

import per.goweii.rxhttp.request.base.BaseBean;

public class QBCodeResponse extends BaseBean {
    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    private String verification_code;
}
