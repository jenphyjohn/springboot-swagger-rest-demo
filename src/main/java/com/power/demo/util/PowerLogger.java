package com.power.demo.util;

import com.mysql.jdbc.log.LogUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类，对slf4j进行一层封装
 */
public final class PowerLogger {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void debug(Exception ex) {
        logger.debug(ExceptionUtils.getMessage(ex));
    }

    public static void debug(String format, Object... args) {
        logger.debug(format, args);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(Exception ex) {
        logger.info(ExceptionUtils.getMessage(ex));
    }

    public static void info(String format, Object... args) {
        logger.info(format, args);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(Exception ex) {
        logger.warn(ExceptionUtils.getMessage(ex));
    }

    public static void warn(String format, Object... args) {
        logger.warn(format, args);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(Exception ex) {
        logger.error(ExceptionUtils.getMessage(ex));
    }

    public static void error(String format, Object... args) {
        logger.error(format, args);
    }
}
