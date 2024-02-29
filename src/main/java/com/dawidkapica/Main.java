package com.dawidkapica;

import com.dawidkapica.mapOwn.HashMapImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        compareJavaHashMapToHashMapImpl(100000);
    }

    private static void compareJavaHashMapToHashMapImpl(int numberOfPuts) {
        long tsJava = System.currentTimeMillis();
        Map<Integer, String> javaHashMap = new HashMap<>();
        for (int i = 0; i < numberOfPuts; i++) {
            javaHashMap.put(i, System.currentTimeMillis() + "");
        }
        long teJava = System.currentTimeMillis();
        System.out.println(teJava - tsJava);

        long tsJOwn = System.currentTimeMillis();
        HashMapImpl<Integer, String> ownHashMap = new HashMapImpl<>();
        for (int i = 0; i < numberOfPuts; i++) {
            ownHashMap.put(i, System.currentTimeMillis() + "");
        }
        long teOwn = System.currentTimeMillis();
        System.out.println(teOwn - tsJOwn);
    }
}