package com.pruebajp.johnparra.bean;

public class MyBeanWithPropertiesImplemented implements MyBeanWitProperties {
    private String name;
    private String lastName;
    public MyBeanWithPropertiesImplemented(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    @Override
    public String function() {
        return name + " - " + lastName;
    }
}
