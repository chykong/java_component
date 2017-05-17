package com.critc.queue;

import java.io.Serializable;

/**
 * 消息内容
 */
public class SmsMessageVo implements Serializable {
    private static final long serialVersionUID = 1L;
    // 手机号
    private String mobile;

    // 短信内容
    private String content;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SmsMessageVo{" +
                "mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
