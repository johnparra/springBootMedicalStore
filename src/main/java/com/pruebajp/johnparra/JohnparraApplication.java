package com.pruebajp.johnparra;

import com.pruebajp.johnparra.bean.MyBean;
import com.pruebajp.johnparra.bean.MyBeanWitProperties;
import com.pruebajp.johnparra.bean.MyBeanWithDependency;
import com.pruebajp.johnparra.component.ComponentDependency;
import com.pruebajp.johnparra.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JohnparraApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWitProperties myBeanWitProperties;

	private UserPojo userPojo;


	public JohnparraApplication(
			@Qualifier("componentImplementTwo") ComponentDependency comDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWitProperties myBeanWitProperties,
			UserPojo userPojo){
		this.componentDependency = comDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWitProperties = myBeanWitProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JohnparraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWitProperties.function());
		System.out.println(userPojo.getEmail() +" - "+ userPojo.getPassword() +" - "+ userPojo.getAge());
	}
}
