package com.androidstudy.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.List;

public class TestType2 {
    List<String>[] mLists;

    public static void main(String[] args) {
        try {
            Field field = TestType2.class.getDeclaredField("mLists");
            GenericArrayType genericArrayType = (GenericArrayType) field.getGenericType();
            System.out.println(genericArrayType.getGenericComponentType()); //java.util.List<java.lang.String>
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
