package com.androidstudy.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.List;

public class TestType3 {

    private List<? extends Number> a; // 上限
    private List<? super String> b; // 下限

    public static void main(String[] args) {
        try {
            Field a1 = TestType3.class.getDeclaredField("a");
            Field b1 = TestType3.class.getDeclaredField("b");

            ParameterizedType parameterizedTypeA = (ParameterizedType) a1.getGenericType();
            ParameterizedType parameterizedTypeB = (ParameterizedType) b1.getGenericType();

            WildcardType wildcardType1 = (WildcardType) parameterizedTypeA.getActualTypeArguments()[0];
            WildcardType wildcardType2 = (WildcardType) parameterizedTypeB.getActualTypeArguments()[0];

            System.out.println(wildcardType1.getUpperBounds()[0]); //class java.lang.Number
            System.out.println(wildcardType2.getUpperBounds()[0]); //class java.lang.Object

            System.out.println(wildcardType1); //? extends java.lang.Number
            System.out.println(wildcardType2); //? super java.lang.String

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
