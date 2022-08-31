package com.pruebajp.johnparra.configuration;

import com.pruebajp.johnparra.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation myOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency myOperationDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
