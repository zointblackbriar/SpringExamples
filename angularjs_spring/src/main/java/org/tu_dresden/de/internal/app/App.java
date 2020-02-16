package org.tu_dresden.de.internal.app;

import java.util.stream.Stream;
import org.tu_dresden.de.internal.app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    CommandLineRunner init(UserRepository userRepository){
    	return args -> {
    		Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
    			User user = new User(name, name.toLowerCase() + "@domain.com");
    		});
    		
    	userRepository.findAll().forEach(System.out::println)
    	}
    }
}
