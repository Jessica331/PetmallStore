package com.wangyp.petmall.util.constant;

/**
 * @Author: Wangyp
 * @Date: 2023/1/2 19:23
 * @Description: *
 */
public class PetmallConstant {

    public static final String MESSAGE_PASSWORD_NOT_MATCH = "抱歉！账号密码错误！请重新输入！";
    public static final String MESSAGE_LOGIN_ACCT_ALREADY_IN_USE = "抱歉！这个账号已经被使用了！";
    public static final String MESSAGE_INSERT_UNKNOWN_ERROR = "添加用户数据出现未知错误，请联系系统管理员";
    public static final String MESSAGE_UNKNOWN_ERROR = "未知错误，请联系系统管理员";
    public static final String MESSAGE_ACCESS_FORBIDEN = "请登录以后再访问！";
    public static final String MESSAGE_STRING_INVALIDATE = "字符串不合法！请不要传入空字符串！";
    public static final String MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE = "系统错误：登录账号不唯一！";
    public static final String MESSAGE_ACCESS_DENIED = "抱歉！您不能访问这个资源！";
    public static final String MESSAGE_CODE_NOT_EXISTS = "验证码已过期！请检查手机号是否正确或重新发送！";
    public static final String MESSAGE_CODE_INVALID = "验证码不正确！";

    public static final Integer SUCCESS = 200;
    public static final Integer FAILED = 400;
    public static final Integer NOT_FINED = 404;
    public static final Integer USERNAME_DUPLICATE = 4000;
    public static final Integer USER_NOT_FOUND = 4001;
    public static final Integer PASSWORD_NOT_MATCH = 4002;
    public static final Integer UNKNOWN_INSERT_ERROR = 5000;
    public static final Integer UNKNOWN_ERROR = 6000;

}
