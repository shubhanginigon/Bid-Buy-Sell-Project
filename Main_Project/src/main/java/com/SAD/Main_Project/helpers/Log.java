package com.SAD.Main_Project.helpers;

public class Logger {



    public static void print(String text) {
        System.out.println(text);
    }

    public static void printWithClassName(String text, Object obj) {
        System.out.println("Message: " + text);
        System.out.println("Class: " + obj.getClass().getSimpleName());
    }
}

class myTest {
    Logger.print("hello");
}
