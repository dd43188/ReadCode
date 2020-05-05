package com.water.readcode;

import java.lang.reflect.Method;

import de.robv.android.xposed.DexposedBridge;
import de.robv.android.xposed.XC_MethodHook;

/**
 * Created by 38164 on 2020/5/5.
 */

public class HookManager {

    private static final String TAG = "HookManager_";
    private static final Class[] hookClassArray = new Class[]{
            MainActivity.class
    };

    public static void init() {
        for(Class target : hookClassArray) {
            hookAllMethod(MainActivity.class);
        }
    }

    private static void hookAllMethod(Class target) {
        if (target == null) {
            log("hookAllMethod class null");
            return;
        }

        Method[] methods = target.getDeclaredMethods();
        for (Method method : methods) {
            DexposedBridge.hookMethod(method, callBack);
        }
    }

    private static XC_MethodHook callBack = new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
            super.beforeHookedMethod(param);
            log("before, " + param.thisObject.getClass().getName() + ", " + param.method.getName());
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            super.afterHookedMethod(param);
            log("after, " + param.thisObject.getClass().getName() + ", " + param.method.getName());
        }
    };

    private static void log(String content) {
        DexposedBridge.log(TAG + content);
    }
}
