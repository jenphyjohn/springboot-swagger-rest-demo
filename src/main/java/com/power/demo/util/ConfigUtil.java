package com.power.demo.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.util.Properties;


/**
 * application.properties配置帮助类
 * <p>
 * Created by JeffWong.
 */
public class ConfigUtil {


    /**
     * 根据配置键读取配置文件的配置
     *
     * @param configKey
     * @return String
     */
    public static String GetConfigVal(String configKey) {
        String val = null;
        if (StringUtils.isEmpty(configKey) == true) {
            return val;
        }

        try {
            org.springframework.core.io.Resource resource = new ClassPathResource("/config/application.properties");
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            val = properties.getProperty(configKey);


        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return val;
    }
}