package com.power.demo.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JeffWong.
 */
public class ValidateUtil {

    /**
     * 验证输入手机号码
     *
     * @param mobile
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean isMobilePhone(String mobile) {
        String regex = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
        return match(regex, mobile);
    }

    public static boolean isEmail(String email) {
        String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return match(regex, email);
    }

    /**
     * 验证IP地址
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean isIP(String str) {
        String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
        String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
        return match(regex, str);
    }

    /**
     * 验证网址Url
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsUrl(String str) {
        String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        return match(regex, str);
    }

    /**
     * 验证输入身份证号
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsIDCard(String str) {
        String regex = "(^\\d{18}$)|(^\\d{15}$)";
        return match(regex, str);
    }

    /**
     * 验证大写字母
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsUpChar(String str) {
        String regex = "^[A-Z]+$";
        return match(regex, str);
    }

    /**
     * 验证小写字母
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsLowChar(String str) {
        String regex = "^[a-z]+$";
        return match(regex, str);
    }

    /**
     * 验证验证输入字母
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsLetter(String str) {
        String regex = "^[A-Za-z]+$";
        return match(regex, str);
    }

    /**
     * 验证验证输入汉字
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsChinese(String str) {
        String regex = "^[\u4e00-\u9fa5],{0,}$";
        return match(regex, str);
    }

    /**
     * 验证密码强度
     * start = 8,end = 30;
     * -1.不符合 1.弱 2.较弱 3.强
     */
    public static int checkPassword(String password, int start, int end) {

        int pwdResult = -1;
        if (password == null) {
            return pwdResult;
        }
        if (password.matches("^\\d+$")) {
            pwdResult = 1;
        } else if (password.matches("^[a-zA-Z]+$")) {
            pwdResult = 2;
        } else if (password.matches("^[\\w\\W]{" + start + "," + end + "}$")) {
            pwdResult = 3;
        }

        return pwdResult;
    }


    /**
     * @param code
     */
    public static boolean isSMSVerifyCode(String code) {
        String regex = "^\\d{6}$";
        return match(regex, code);
    }

    /**
     * @param code
     */
    public static boolean isImageVerifyCode(String code) {
        String regex = "^.{4}$";
        return match(regex, code);
    }

    /**
     * 是否输入guid
     *
     * @param id
     * @return
     */
    public static boolean isGuid(String id) {
        try {
            UUID.fromString(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否输入字符
     *
     * @param str
     * @return
     */
    public static boolean isCommonCharacter(String str) {
        String regex = "^[\\w|-]*$";
        return match(regex, str);
    }

    /**
     * 验证输入一年的12个月
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsMonth(String str) {
        String regex = "^(0?[[1-9]|1[0-2])$";
        return match(regex, str);
    }

    /**
     * 验证输入一个月的31天
     *
     * @param str
     * @return 如果是符合格式的字符串, 返回 true,否则为false
     */
    public static boolean IsDay(String str) {
        String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
        return match(regex, str);
    }

    /**
     * 验证日期时间
     *
     * @param str
     * @return 如果是符合网址格式的字符串, 返回 true,否则为false
     */
    public static boolean isDate(String str) {
        // 严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
        // [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
        // String regex =
        // "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
        // 没加时间验证的YYYY-MM-DD
        // String regex =
        // "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
        // 加了时间验证的YYYY-MM-DD 00:00:00
        String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
        return match(regex, str);
    }

    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        if (str == null || str.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
