package com.example.TCP.Sleep;

public class Sleep {

    public static void sleep() {
        System.out.println("::::::::::::::::::::::::::::::");

        System.out.println("                              ");

        // Sleep for 3 seconds
        try {
            Thread.sleep(3000); // Sleep for 3000 milliseconds (3 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
