package com.arthas.learningcurve.utils;

import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Created by Shawn on 2014/9/24.
 */
public class InputValidatorUtils {

    public static final String REGEXP_NUMBER = "^-?\\d+$";
    public static final String REGEXP_EMAIL = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public static final String REGEXP_CHINESE_STR = "^[\u4E00-\u9FA5]+$";
    public static final String REGEXP_ENGLISH_STR = "^[a-z|A-Z]+$";
    public static final String REGEXP_IDCARD_15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
    public static final String REGEXP_IDCARD_18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";
    public static final String REGEXP_CHAR = "^[\u4E00-\u9FA50-9a-zA-Z]+$";
    public static final String REGEXP_MULTI_PHONE = "^(((\\d{11})|((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})))([；、;，、,]?))+$";
    public static final String REGEXP_PHONE = "((^\\d{11}$)|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)";
    public static final String REGEXT_SIXNUMBER ="^[0-9]{6}";

    /**
     * 11位数字，要做必要的手机号规范检测
     */
//    public static final String REGEXP_MOBILE = "^1[345789]{1}\\d{9}$";
    public static final String REGEXP_MOBILE = "^1(3[0-9]|4[57]|5[0-35-9]|7[678]|8[0-9]|70)\\d{8}$";
    /**
     * 4-50个汉字，不允许字母、数字和特殊字符
     */
    public static final String REGEXP_COMPANY_NAME = "^[\\u4E00-\\u9FA5]{4,50}$";
    /** 2-15个汉字，不允许字母、数字和特殊字符除了.号
    */
    public static final String REGEXP_AUTH_NAME = "^[\\u4E00-\\u9FA5]([\\u4E00-\\u9FA5]|[\\.|·]){0,13}[\\u4E00-\\u9FA5]{1}$";
    /** 1-50个汉字，不允许字母、数字和特殊字符
     */
    public static final String REGEXP_AUTH_COMPANY_NAME = "^[\\u4E00-\\u9FA5]{1,50}$";
    //15位数字字母
    public static final String REGEXP_AUTH_COMPANY_BUSINESS_NUM = "^[a-zA-Z0-9]{13}|^[a-zA-Z0-9]{15}$|^[a-zA-Z0-9]{18}$";
    /**
     * 6-20位字母、数字、连接线、下划线；
     */
//    public static final String REGEXP_ACCOUNT_NAME = "^([a-zA-Z0-9-_\\.]|[\\u4E00-\\u9FA5]){4,20}$";
    public static final String REGEXP_ACCOUNT_NAME = "^([a-zA-Z0-9-_]|[\\u4E00-\\u9FA5]){4,20}$";
    /**
     * 6-20位不全是数字
     */
    public static final String REGEXP_ALLNUM_ACCOUNT_NAME = "^[0-9]{6,20}$";
    /**
     * 8-20位字母、数字、特殊字符（开发规定不能使用的特殊字符）
     */
    public static final String REGEXP_PASSWORD = "^[a-zA-z0-9]{6,20}$";

    public static final Pattern REG_NUMBER = Pattern.compile(REGEXP_NUMBER);
    public static final Pattern REG_EMAIL = Pattern.compile(REGEXP_EMAIL);
    public static final Pattern REG_MOBILE = Pattern.compile(REGEXP_MOBILE);
    public static final Pattern REG_CHINESE_STR = Pattern.compile(REGEXP_CHINESE_STR);
    public static final Pattern REG_ENGLISH_STR = Pattern.compile(REGEXP_ENGLISH_STR);
    public static final Pattern REG_IDCARD_15 = Pattern.compile(REGEXP_IDCARD_15);
    public static final Pattern REG_IDCARD_18 = Pattern.compile(REGEXP_IDCARD_18);
    public static final Pattern REG_CHAR = Pattern.compile(REGEXP_CHAR);
    public static final Pattern REG_MULTI_PHONE = Pattern.compile(REGEXP_MULTI_PHONE);
    public static final Pattern REG_PHONE = Pattern.compile(REGEXP_PHONE);
    public static final Pattern REG_COMPANY_NAME = Pattern.compile(REGEXP_COMPANY_NAME);
    public static final Pattern REG_ACCOUNT_NAME = Pattern.compile(REGEXP_ACCOUNT_NAME);
    public static final Pattern REG_PASSWORD = Pattern.compile(REGEXP_PASSWORD);
    public static final Pattern REG_SIXNUMBER = Pattern.compile(REGEXT_SIXNUMBER);
    public static final Pattern REG_ALLNUM_ACCOUNT_NAME =Pattern.compile(REGEXP_ALLNUM_ACCOUNT_NAME);
    public static final Pattern REG_AUTH_NAME = Pattern.compile(REGEXP_AUTH_NAME);
    public static final Pattern REG_AUTH_COMPANY_NAME = Pattern.compile(REGEXP_AUTH_COMPANY_NAME);
    public static final Pattern REG_AUTH_COMPANY_BUSINESS_NUM = Pattern.compile(REGEXP_AUTH_COMPANY_BUSINESS_NUM);
    /**
     * 判断String是否为null或""
     */
    public static boolean isEmpty(String value) {
        return value == null || value.trim().equals("");
    }

    public static boolean isEmpty(TextView textView){
        return textView == null || textView.getText() == null || textView.getText().equals("");
    }

    public static boolean isEmpty(EditText editText){
        return editText == null || editText.getText() == null || editText.getText().toString().equals("");
    }

    /**
     * 验证是中文或字母或数字
     */
    public static boolean isChar(String value) {
        return isMatch(REG_CHAR, value);
    }

    /**
     * 验证字符串为多个电话号码
     */
    public static boolean isMultiPhone(String value) {
        return isMatch(REG_MULTI_PHONE, value);
    }

    /**
     * 是否匹配正则表达式
     */
    public static boolean isMatch(String regexp, String value) {
        return isMatch(Pattern.compile(regexp), value);
    }

    public static boolean isMatch(Pattern patt, String value) {
        if (isEmpty(value)) {
            return false;
        }
        return patt.matcher(value).matches();
    }

    public static boolean isFind(Pattern patt, String value) {
        if (isEmpty(value)) {
            return false;
        }
        return patt.matcher(value).find();
    }

    /**
     * 判断是否为数字
     */
    public static boolean isNumber(String value) {
        return isMatch(REG_NUMBER, value);
    }
    /**
     * 判断是否为0-9的6位数字
     */
    public static boolean isSixNumber(String value) {
        return isMatch(REGEXT_SIXNUMBER, value);
    }

    /**
     * 判断是否为邮箱地址
     */
    public static boolean isEmail(String value) {
        return isMatch(REG_EMAIL, value);
    }

    /**
     * 判断是否为手机号码
     */
    public static boolean isMobile(String value) {
         return isMatch(REG_MOBILE, value);
    }

    /**
     * 是否为英文字符串
     */
    public static boolean isEnglishString(String value) {
        return isMatch(REG_ENGLISH_STR, value);
    }

    /**
     * 是否为中文字符串
     */
    public static boolean isChineseString(String value) {
        return isMatch(REG_CHINESE_STR, value);
    }

    /**
     * 是否为工商注册号
     */
    public static boolean isBusinessNum(String value) {
    	 return isMatch(REG_AUTH_COMPANY_BUSINESS_NUM, value);
//    	return new CheckBusinessNumber().validate(value);
    }
    /**
     * 是否为身份证号码
     */
    public static boolean isIDcard(String value) {
//        return isMatch(REG_IDCARD_15, value) || isMatch(REG_IDCARD_18, value);
    	return isIDcardX(value);
    }

    public static boolean isIDcardX(String value) {
    	return new IdCardUtils(value).validate();
    }

    /**
     * 验证字符串为电话号码
     * 11位数字，要做必要的手机号规范检测
     */
    public static boolean isPhone(String value) {
        return isMatch(REG_PHONE, value);
    }

    /**
     * 验证注册时输入的公司名称
     * 4-50个汉字，不允许字母、数字和特殊字符
     */
    public static boolean isRegisterCompanyNameValid(String value) {
        return isMatch(REG_COMPANY_NAME, value);
    }

    /**
     * 验证注册时的会员名
     * 6-20位字母、数字、连接线、下划线
     */
    public static boolean isRegisterAccountNameValid(String value) {
        return isMatch(REG_ACCOUNT_NAME, value);
    }
    /**
     * 验证注册时的会员名
     * 6-20是否全为数字
     */
    public static boolean isAllNUMAccountNameValid(String value){
    	return isMatch(REG_ALLNUM_ACCOUNT_NAME,value);
    }

    /**
     * 验证密码，确认密码
     * 8-20位字母、数字、特殊字符（开发规定不能使用的特殊字符）
     */
    public static boolean isRegisterPasswordValid(String value) {
        return isMatch(REG_PASSWORD, value);
    }
    
    /**
     * 验证认证个体户名称
     * 15个汉字，不允许字母、数字和特殊字符
     */
    public static boolean isAuthNameValid(String value) {
        return isMatch(REG_AUTH_NAME, value);
    }
    /**
     * 验证认证个体户名称
     * 不超过50个汉字，不允许字母、数字和特殊字符
     */
    public static boolean isAuthCompanyNameValid(String value) {
    	return isMatch(REG_AUTH_COMPANY_NAME, value);
    }
}
