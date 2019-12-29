package com.sprAnnotation.aop;

public class MathCalculator {
    public int div(int a , int b){
        System.out.println("MathCaculator div("+a+", "+b+")");
        return  a/b;
    }
}
