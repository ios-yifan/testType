package com.androidstudy.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class TestType1 {
    Map<String, String> mMap;

    public static void main(String[] args) {
        try {
            Field field = TestType1.class.getDeclaredField("mMap");
            System.out.println(field.getGenericType()); //java.util.Map<java.lang.String, java.lang.String>
            ParameterizedType parameterizedType  = (ParameterizedType) field.getGenericType();
            System.out.println(parameterizedType.getRawType()); //interface java.util.Map

            for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {
                System.out.println(actualTypeArgument);
                //class java.lang.String
                //class java.lang.String
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
