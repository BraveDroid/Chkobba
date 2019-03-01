package com.bravedroid.util;

public class Helper {
    //while (i < n){
    // .....
    // }
    public static void repeat(Runnable runnable, int n) {
        int i = 0;
        while (i < n) {
            runnable.run();
            i++;
        }
    }
}
