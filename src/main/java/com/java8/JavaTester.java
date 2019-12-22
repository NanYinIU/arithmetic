package com.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaTester {

    @Test
    public void functionTest(){
        // R apply(T t);
        // Function<T, R>
        // 定义默认方法实现
//        Function<String,Integer> fun = (s) -> Integer.parseInt(s+"1");

        Function<String,Integer> fun = Integer::parseInt;

        List<Integer> list = Arrays.asList(1,2,3);

        JavaTester javaTester = new JavaTester();
//        List<Integer> resList = javaTester.functionMethods(list,(a)->a.stream().filter((b)-> b!=2).collect(Collectors.toList()));
        List<Integer> resList = javaTester.functionMethods2(list,a -> {a.add(2);return a;});
        resList.forEach(System.out::println);
        // 执行实现的方法
//        Integer result = fun.apply("2");
//        System.out.println(result);
    }

    List<Integer> functionMethods(List<Integer> a,Function<List<Integer>,List<Integer>> function){
       return function.apply(a);
    }

    List<Integer> functionMethods2(List<Integer> a,Function<List<Integer>,List<Integer>> function){
        a = a.stream()
                .filter(demoFilter(2))
                .collect(Collectors.toList());
        return function.apply(a);
    }

    void NumberFilter(Integer t,Predicate<Integer> predicate){
        predicate.test(t);
    }

    Predicate<Integer> demoFilter(Integer number){
        return (a)-> !a.equals(number);
    }



}
