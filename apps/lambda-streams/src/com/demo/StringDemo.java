package com.demo;

public class StringDemo {
    public static void main(String[] args) {
        String s1="hello";
        String s2="hello";
        String s3="Hello";
        String s4=new String("Hello");

        System.out.println(s4==s3);


        StringBuilder sb= new StringBuilder();

        sb.append("Shantanu").append(" is ").append("from ").append("Dhanbad");
        System.out.println(sb);
        sb.replace(sb.indexOf("Dhanbad"),sb.indexOf("Dhanbad")+"Dhanbad".length(),"Hyderabad");
        System.out.println(sb);
    }
}
