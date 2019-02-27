package com.bravedroid.util;

public class Logger {
    private boolean isDebug;

    public Logger(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public void log(Object msg) {
        if (isDebug) {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            final int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.out.println("***" + className + "_" + lineNumber + "***" + "\n"
                    + msg + "***");
        }
    }
}
