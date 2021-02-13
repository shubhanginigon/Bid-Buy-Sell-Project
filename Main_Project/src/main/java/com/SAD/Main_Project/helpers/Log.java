package com.SAD.Main_Project.helpers;

public class Log {

    private static volatile Log shared;

    private Log() {}

    public static Log getInstance() {
        if (shared == null) {
            synchronized (Log.class) {
                if (shared == null) {
                    shared = new Log();
                }
            }
        }
        return shared;
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printWithClassName(String text, Object obj) {
        System.out.println("Message: " + text);
        System.out.println("Class: " + obj.getClass().getSimpleName());
    }
}
