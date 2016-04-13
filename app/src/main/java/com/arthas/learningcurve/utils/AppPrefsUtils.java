package com.arthas.learningcurve.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.arthas.learningcurve.base.BaseApplication;

public class AppPrefsUtils {
	private static final String SP_TABLE_NAME = "learning_curve";

	private static SharedPreferences sp;
	private static Editor ed;

	static{
		sp = BaseApplication.getAppContext().getSharedPreferences(SP_TABLE_NAME, Context.MODE_PRIVATE);
		ed = sp.edit();
	}

	private AppPrefsUtils() {

	}

	public static void putBoolean(String key, boolean value){
		ed.putBoolean(key, value);
		ed.commit();
	}

	/**
	 * 默认false
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(String key){
		return sp.getBoolean(key, false);
	}

    /**
     *可以设置默认值
     * @param key
     * @param defaultValue
     * @return
     */
	public static boolean getBoolean(String key, boolean defaultValue){
		return sp.getBoolean(key, defaultValue);
	}

	public static void putString(String key, String value){
		ed.putString(key, value);
		ed.commit();
	}

	public static String getString(String key){
		return sp.getString(key, "");
	}

    public static String getString(String key,String defaultValue){
        return sp.getString(key, defaultValue);
    }

    public static void putInt(String key, int value){
        ed.putInt(key, value);
        ed.commit();
    }

    /**
     * 默认0
     * @param key
     * @return
     */
    public static int getInt(String key){
        return sp.getInt(key, 0);
    }

}
