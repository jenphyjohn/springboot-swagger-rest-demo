package com.power.demo.util;

import com.power.demo.config.ConfigBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * Created by JeffWong.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigUtilTest {


    @Autowired
    private ConfigBean configBean;

    @Value("${spring.power.appId}")
    private String appId;


    @Test
    public void testGetConfigVal() throws Exception {

        String curAppId = ConfigUtil.GetConfigVal("spring.power.appId");

        Assert.notNull(curAppId, "当前应用ID");

        String isWriteLog = ConfigUtil.GetConfigVal("spring.power.isWriteLocalLog");

        Assert.isNull(isWriteLog, "是否写入本地文本日志");

        System.out.println(String.format("当前应用:%s", configBean.getAppId()));

        System.out.println(String.format("当前应用:%s", appId));

        System.out.println(String.format("是否记录本地文本日志:%s", configBean.getIsWriteLocalLog()));

    }
}