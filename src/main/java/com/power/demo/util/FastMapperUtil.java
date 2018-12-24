package com.power.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射映射帮助类
 * <p>
 * Created by JeffWong.
 */
public class FastMapperUtil {

    /**
     * 取Bean的属性和值对应关系的MAP
     *
     * @param bean
     * @return Map
     */
    public static Map<String, Object> getFieldValueMap(Object bean) {
        Map<String, Object> valueMap = new HashMap<String, Object>();
        if (bean == null) {
            return valueMap;
        }

        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                String strKeyName = field.getName();
                //String fieldType = field.getType().getSimpleName();
                String fieldGetName = parGetName(strKeyName);
                if (checkExistMethod(methods, fieldGetName) == false) {
                    continue;
                }
                Method fieldGetMet = clazz.getMethod(fieldGetName);
                Object fieldVal = fieldGetMet.invoke(bean);
                valueMap.put(strKeyName, fieldVal);
            } catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
        }

        System.out.println(valueMap);

        return valueMap;
    }

    /**
     * set属性的值到Bean
     *
     * @param dest   需要实例化
     * @param source 需要实例化
     */
    public static void setFieldValue(Object dest, Object source) {

        if (dest == null) {
            return;
        }
        if (source == null) {
            return;
        }

        Map<String, Object> valMap = getFieldValueMap(source);
        Class<?> clazz = dest.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                String fieldSetName = parSetName(field.getName());
                if (checkExistMethod(methods, fieldSetName) == false) {
                    continue;
                }
                Method fieldSetMet = clazz.getMethod(fieldSetName, field.getType());
                String fieldKeyName = field.getName();
                if (valMap.containsKey(fieldKeyName) == false) {
                    continue;
                }
                Object value = valMap.get(fieldKeyName);
                fieldSetMet.invoke(dest, value);

                System.out.println(value);
            } catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }

    /**
     * 判断是否存在某属性的 get/set方法
     *
     * @param methodArr
     * @param fieldMet
     * @return boolean
     */
    public static boolean checkExistMethod(Method[] methodArr, String fieldMet) {
        boolean exist = false;
        for (Method met : methodArr) {
            if (met.getName().equals(fieldMet)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    public static String parGetName(String fieldName) {
        String result = "";
        if (null == fieldName || "".equals(fieldName)) {
            return result;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_') {
            startIndex = 1;
        }
        result = "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);

        return result;
    }

    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    public static String parSetName(String fieldName) {
        String result = "";
        if (null == fieldName || "".equals(fieldName)) {
            return result;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_') {
            startIndex = 1;
        }

        result = "set"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
        return result;
    }

    /**
     * 获取存储的键名称（调用parGetName）
     *
     * @param fieldName
     * @return 去掉开头的get
     */
    public static String parKeyName(String fieldName) {
        String fieldGetName = parGetName(fieldName);
        if (fieldGetName != null && fieldGetName.trim() != ""
                && fieldGetName.length() > 3) {
            return fieldGetName.substring(3);
        }
        return fieldGetName;
    }

}
