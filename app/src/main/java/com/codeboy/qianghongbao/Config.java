package com.codeboy.qianghongbao;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * <p>Created 16/1/15 下午10:59.</p>
 * <p><a href="mailto:codeboy2013@gmail.com">Email:codeboy2013@gmail.com</a></p>
 * <p><a href="http://www.happycodeboy.com">LeonLee Blog</a></p>
 *
 * @author LeonLee
 */
public class Config {

    public static final String ACTION_QIANGHONGBAO_SERVICE_DISCONNECT = "com.codeboy.qianghongbao.ACCESSBILITY_DISCONNECT";
    public static final String ACTION_QIANGHONGBAO_SERVICE_CONNECT = "com.codeboy.qianghongbao.ACCESSBILITY_CONNECT";

    public static final String PREFERENCE_NAME = "config";
    public static final String KEY_ENABLE_WECHAT = "KEY_ENABLE_WECHAT";
    public static final String KEY_WECHAT_AFTER_OPEN_HONGBAO = "KEY_WECHAT_AFTER_OPEN_HONGBAO";
    public static final String KEY_WECHAT_DELAY_TIME = "KEY_WECHAT_DELAY_TIME";
    public static final String KEY_IGNORE_HONGBAO_FORM = "KEY_IGNORE_HONGBAO_FORM";

    public static final int WX_AFTER_OPEN_HONGBAO = 0;
    public static final int WX_AFTER_OPEN_SEE = 1; //看大家手气
    public static final String WX_IGNORE_HONGBAO_FORM = "";//#陕西际融#陕西思宇

    SharedPreferences preferences;

    public Config(Context context) {
        preferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /** 是否启动微信抢红包*/
    public boolean isEnableWechat() {
        return preferences.getBoolean(KEY_ENABLE_WECHAT, true);
    }

    /** 微信打开红包后的事件*/
    public int getWechatAfterOpenHongBaoEvent() {
        int defaultValue = 0;
        String result =  preferences.getString(KEY_WECHAT_AFTER_OPEN_HONGBAO, String.valueOf(defaultValue));
        try {
            return Integer.parseInt(result);
        } catch (Exception e) {}
        return defaultValue;
    }

    /** 微信打开红包后延时时间*/
    public int getWechatOpenDelayTime() {
        int defaultValue = 0;
        String result = preferences.getString(KEY_WECHAT_DELAY_TIME, String.valueOf(defaultValue));
        try {
            return Integer.parseInt(result);
        } catch (Exception e) {}
        return defaultValue;
    }

    /** 获取忽略红包来源*/
    public String getIgnoreHongBaoFormText() {
        //增加红包来源过滤 update by lujw
        String defaultValue = "";
        String result = preferences.getString(KEY_IGNORE_HONGBAO_FORM, defaultValue);
        if(result == null || "".equals(result.trim())){
            return defaultValue;
        }
        return result;
    }

    /** 获取忽略红包来源*/
    public String[] getIgnoreHongBaoForms() {
        //增加红包来源过滤 update by lujw
        String result = preferences.getString(KEY_IGNORE_HONGBAO_FORM, WX_IGNORE_HONGBAO_FORM);
        return result.split("#");
    }
}
