package com.effctiveJava;

/**
 * @author nanyin
 * @class School.java
 * @description TODO
 * @create 23:38 2020-04-04
 */
public class School {
    private static final int master = 1;
    private static final int teacher = 1 << 1;
    private static  final int student = 1 << 2;

    public void doSometing(int role){
        if (role == 1) {
            System.out.println("master");
        }else  if(role == 2) {
            System.out.println("teacher");
        }else if(role == 3){
            System.out.println("teacher + master");
        }
    }

    public static void main(String[] args) {
        School school = new School();
        school.doSometing(1);
        school.doSometing(3);
    }
}
