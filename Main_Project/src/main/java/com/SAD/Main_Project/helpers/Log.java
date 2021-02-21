package com.SAD.Main_Project.helpers;

public class Log {

    public static volatile Log shared;

    private Log() {
    }

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

    // Printing Methods
    private void print(String text) {
        System.out.println(text);
    }

    private void print(String text, Object obj) {
        System.out.println("Message: " + text);
        System.out.println("From Class: " + obj.getClass().getSimpleName());
    }
}
