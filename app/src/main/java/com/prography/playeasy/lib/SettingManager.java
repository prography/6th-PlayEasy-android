package com.prography.playeasy.lib;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingManager {

    private static final String PREFERENCES_NAME = "ALARM_SETTING";
    private static final Boolean DEFAULT_STATE = false;


    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
    /**
     * 스위치 상태 저장하기
     *
     * @param context context
     * @param switchKey String
     * @param state Boolean
     */
    public static void set(Context context, String switchKey, Boolean state) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(switchKey, state);
        editor.apply();
    }

    /**
     * 설정 상태 가져오기
     *
     * @param context Context
     * @param switchKey String
     * @return
     */

    public static Boolean get(Context context, String switchKey) {
        SharedPreferences prefs = getPreferences(context);
        return prefs.getBoolean(switchKey, DEFAULT_STATE);
    }

}
