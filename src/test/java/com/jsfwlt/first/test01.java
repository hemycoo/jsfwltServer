package com.jsfwlt.first;


import java.util.Scanner;
import java.util.UUID;

public class test01 {
    public static void main(String[] args) {
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
    }
}