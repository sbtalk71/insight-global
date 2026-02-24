package com.demo.ex1;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties props= new Properties();

        props.setProperty("name","Shantanu");

        System.out.println(props.getProperty("name"));

       Properties sysProps = System.getProperties();

        Set<Object> keys=sysProps.keySet();

        for(Object key:keys){
            System.out.println(key+" --- > "+sysProps.get(key));
        }
    }
}
