package de.tu_dresden.multiplexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(DemoApplication.class, args);
		for(String name : appContext.getBeanDefinitionNames())
		{
			System.out.println(name);
		}
	}

}
