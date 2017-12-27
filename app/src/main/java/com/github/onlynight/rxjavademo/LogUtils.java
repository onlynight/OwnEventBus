package com.github.onlynight.rxjavademo;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by wyndam on 2017/12/26.
 */

public class LogUtils {

    public static final String TAG = LogUtils.class.getSimpleName();

    static {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static void D(Object object) {
        Logger.d(object);
    }

    public static void I(String message, Object object) {
        Logger.i(message, object);
    }

    public static void I(Object object) {
        Logger.i(TAG, object);
    }

    public static void exception(Throwable throwable) {
        Logger.e(throwable, TAG);
    }

}
