package com.power.demo.common;

/**
 * 业务逻辑结果   全局通用业务实体
 * <p>
 * Created by JeffWong.
 */
public class BizResult<T> {

    /// <summary>
    /// 构造函数
    /// </summary>
    /// <param name="isOK">操作业务结果</param>
    public BizResult(boolean isOK) {
        this.setIsOK(isOK);
    }

    /// <summary>
    /// 构造函数
    /// </summary>
    /// <param name="isOK">操作业务结果</param>
    /// <param name="resultCode">业务结果代码</param>
    public BizResult(boolean isOK, int resultCode) {
        this.setIsOK(isOK);
        this.setCode(resultCode);
    }

    /// <summary>
    /// 构造函数
    /// </summary>
    /// <param name="isOK">操作业务结果</param>
    /// <param name="message">业务结果信息</param>
    public BizResult(boolean isOK, String message) {
        this.setIsOK(isOK);
        this.setMessage(message);
    }

    /// <summary>
    /// 构造函数
    /// </summary>
    /// <param name="isOK">操作业务结果</param>
    /// <param name="resultCode">业务结果代码</param>
    /// <param name="message">业务结果信息</param>
    public BizResult(boolean isOK, int resultCode, String message) {
        this.setIsOK(isOK);
        this.setCode(resultCode);
        this.setMessage(message);
    }

    /// <summary>
    /// 业务结果标志 (true:成功,false：失败)
    /// </summary>
    public boolean isOK;

    /// <summary>
    /// 业务结果代码(如0成功，-1失败，-2异常）
    /// </summary>
    public int code;

    /// <summary>
    /// 业务结果消息 (如操作成功/失败等）
    /// </summary>
    public String message;

    /// <summary>
    /// 返回对象
    /// </summary>
    public T returnObject;
    /// <summary>
    /// 返回内部异常
    /// </summary>
    public Exception innerException;

    /// <summary>
    /// 返回的扩展属性
    /// </summary>
    public Object extendObject;

    public boolean isOK() {
        return isOK;
    }

    public void setIsOK(boolean isOK) {
        this.isOK = isOK;
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

    public T getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(T returnObject) {
        this.returnObject = returnObject;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setInnerException(Exception innerException) {
        this.innerException = innerException;
    }

    public Object getExtendObject() {
        return extendObject;
    }

    public void setExtendObject(Object extendObject) {
        this.extendObject = extendObject;
    }

    public void setFail(String msg) {
        this.setIsOK(false);
        this.setMessage(msg);
        this.setCode(AppConst.Fail);
    }

    public void setFail(String msg, Exception ex) {
        this.setIsOK(false);
        this.setMessage(msg);
        this.setCode(AppConst.Fail);
        this.setInnerException(ex);
    }

    public void setSuccess(String msg) {
        this.setIsOK(true);
        this.setMessage(msg);
        this.setCode(AppConst.Success);
    }

}
