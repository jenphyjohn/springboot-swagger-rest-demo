package com.power.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义配置信息
 * <p>
 * Created by JeffWong.
 */
@ConfigurationProperties(prefix = "spring.power")
public class ConfigBean {

    private String appId;

    private String isWriteLocalLog;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getIsWriteLocalLog() {
        return isWriteLocalLog;
    }

    public void setIsWriteLocalLog(String isWriteLocalLog) {
        this.isWriteLocalLog = isWriteLocalLog;
    }
}
