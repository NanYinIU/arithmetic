package com.nanyin;

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
}
