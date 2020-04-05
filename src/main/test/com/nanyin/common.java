package com.basic;

import org.junit.Test;

public class common {
    @Test
    public void test1(){
        int start = 1;
        int end = 0;
        float midValue = (float)(start-end)/2;
        int newMid = (int)Math.floor(midValue);
        System.out.println(newMid);
    }
    @Test
    public void test2(){
       int a = 0;
       int i = 1;
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++i);
        System.out.println();
    }
}
