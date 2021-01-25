package com.androidstudy.type;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
// Comparable 排序接口
// Serializable 一个对象序列化的接口，一个类只有实现了Serializable接口，它的对象才能被序列化
public class TestType <K extends Comparable & Serializable, V>{
    K key;
    V value;

    public static void main(String[] args) {

        try {

            Field fk = TestType.class.getDeclaredField("key");
            Field fv = TestType.class.getDeclaredField("value");

            TypeVariable genericTypeK = (TypeVariable) fk.getGenericType();
            TypeVariable genericTypeV = (TypeVariable) fv.getGenericType();


            System.out.println(genericTypeK.getName() + "name");  //Kname
            System.out.println(genericTypeV.getName() + "name");  //Vname

            System.out.println(genericTypeK.getGenericDeclaration()); //class com.androidstudy.type.TestType
            System.out.println(genericTypeV.getGenericDeclaration()); //class com.androidstudy.type.TestType

            System.out.println("K 的上界:");
            for (Type type : genericTypeK.getBounds()) {
                System.out.println(type);
                //interface java.lang.Comparable
                //interface java.io.Serializable
            }

            System.out.println("V 的上界:");
            for (Type type : genericTypeV.getBounds()) {
                System.out.println(type);
                //class java.lang.Object  没明确声明上界的, 默认上界是 Object
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

//public interface TypeVariable<D extends GenericDeclaration> extends Type {
//  //获得泛型的上限，若未明确声明上边界则默认为Object
//  Type[] getBounds();
//  //获取声明该类型变量实体(即获得类、方法或构造器名)
//  D getGenericDeclaration();
//  //获得名称，即K、V、E之类名称
//  String getName();
//}
