package com.arthas.learningcurve.common;

/**
 * Created by Tcz on 16/4/13.
 */
public interface Constant {
    interface  SpUserConstant{
        String KEY_USER_ID = "key_user_id";
        String KEY_USER_INFO = "key_user_info";
    }

    String KEY_CLASS_NAME = "key_class_name";

    /**
     * icon name
     */
    String KEY_ICON_FONT = "key_icon_font";

    /**
     *  三级目录
     */
    interface CategoryLevel{
        int FIRST_LEVEL = 1;
        int SECOND_LEVEL = 2;
        int THIRD_LEVEL = 3;
    }
}
