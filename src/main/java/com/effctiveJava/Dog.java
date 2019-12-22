package com.effctiveJava;

public class Dog {
    private String name;
    private Dog(){};
    // 1.导出Public的变量
//    private static final Dog INSTANCE = new Dog();
    // 2.使用public 的工厂方法
    private static final Dog INSTANCE = new Dog();

    public static Dog getInstance(){
        return INSTANCE;
    }



}
