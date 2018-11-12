package com.dylan.common.bean.http;

/****
 * 返回客户端数据集合
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    private RespBean() {
    }

    public static RespBean build() {
        return new RespBean();
    }

    /**
     * 网络请求成功
     *
     * @param msg
     * @param obj
     * @return
     */
    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }


    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }

    /**
     * 一般服务内部网络异常
     *
     * @param msg
     * @return
     */
    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean error(int code, String msg) {
        return new RespBean(code, msg, null);
    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {

        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
