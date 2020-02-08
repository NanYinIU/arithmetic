package com.effctiveJava;

public class School {
//    private static final Traffic BIKE = new Bike();
//
//    private School() {
//    }
//
//    public static void goTo(){
//        BIKE.run();
//    }

    private final Traffic traffic;

    public School(Traffic traffic) {
        this.traffic = traffic;
    }

    public void goTo(){
        traffic.run();
    }
}
