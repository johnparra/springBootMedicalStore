package com.pruebajp.johnparra.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
public class UserPojo {
    private String email, password;
    private int age;

    public UserPojo(String email, String password, int age){
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public int getAge(){
        return age;
    }
}
