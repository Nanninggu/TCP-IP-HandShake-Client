package com.example.TCP.Sleep;

public class SleepFor10000 {

    public static void sleep() {
        System.out.println("::::::::::::::::::::::::::::::");

        System.out.println("                              ");

        // Sleep for 3 seconds
        try {
            Thread.sleep(10000); // Sleep for 3000 milliseconds (3 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
