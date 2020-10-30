package org.tu_dresden.de.internal.app;

import java.util.stream.Stream;
import org.tu_dresden.de.internal.app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tu_dresden.de.internal.entities.User;
import org.tu_dresden.de.internal.service.ProductService;
import org.tu_dresden.internal.app.datamodel.Product;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args); // Convert this an ecommerce application
        // we will simulate a self-adaptive microservice
        // change worker threads and processes after heavy loading.
    }
    
//    @Bean
//    CommandLineRunner init(UserRepository userRepository){
//    	return args -> {
//    		Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//    			User user = new User(name, name.toLowerCase() + "@domain.com");
//    		});
//    		
//    	userRepository.findAll().forEach(System.out::println);
//    	};
//    }
    
    @Bean
    CommandLineRunner runner(ProductService productService) {
    	//input parameters - 3 Products are enough to show
    	return args -> {
    		productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
    		productService.save(new Product(2L, "Game Console", 400.00, "http://mediamarkt.de/100x100"));
    		productService.save(new Product(3L, "Sofa", 500.00, "http://afw.com/20x20"));
    	};
    }
}
