package com.pruebajp.johnparra;

import com.pruebajp.johnparra.bean.MyBean;
import com.pruebajp.johnparra.bean.MyBeanWitProperties;
import com.pruebajp.johnparra.bean.MyBeanWithDependency;
import com.pruebajp.johnparra.component.ComponentDependency;
import com.pruebajp.johnparra.entity.Customer;
import com.pruebajp.johnparra.pojo.UserPojo;
import com.pruebajp.johnparra.repository.CustomerRepository;
import com.pruebajp.johnparra.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JohnparraApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWitProperties myBeanWitProperties;
	private UserPojo userPojo;

	private CustomerRepository customerRepository;


	public JohnparraApplication(
			@Qualifier("componentImplementTwo") ComponentDependency comDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWitProperties myBeanWitProperties,
			UserPojo userPojo,
			CustomerRepository customerRepository){
		this.componentDependency = comDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWitProperties = myBeanWitProperties;
		this.userPojo = userPojo;
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JohnparraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//pruebas();
		saveCustomersInDB();
		getInformation();
	}

	private void getInformation(){
		System.out.println("El producto más vendido es: "+
				OrderRepository.findMostAndMinusSeller(Sort.by("id").ascending()));
		System.out.println("El producto menos vendido es: "+
				OrderRepository.findMostAndMinusSeller(Sort.by("id").descending()));
		System.out.println("El total de las ventas de la drogueria es: "+
				OrderRepository.showTotalSells());
	}

	private void saveCustomersInDB(){
		Customer customer1 = new Customer("Pedro","Perez", 12345671L);
		Customer customer2 = new Customer("Carlos","Giraldo", 12345672L);
		Customer customer3 = new Customer("Diana","Gutierrez", 12345673L);
		Customer customer4 = new Customer("Patricio","Osairis", 12345674L);
		Customer customer5 = new Customer("Bob","Herrera", 12345675L);
		List<Customer> customerList = Arrays.asList(customer1,customer2,customer3,customer4,customer5);
		customerList.stream().forEach(customerRepository::save);
	}

	private void pruebas() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWitProperties.function());
		System.out.println(userPojo.getEmail() +" - "+ userPojo.getPassword() +" - "+ userPojo.getAge());
	}
}
