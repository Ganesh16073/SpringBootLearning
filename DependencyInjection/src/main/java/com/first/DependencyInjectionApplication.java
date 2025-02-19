package com.first;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.first.model.SeasonFinder;



@SpringBootApplication
public class DependencyInjectionApplication {
	
	@Bean(name = "ld")
	public LocalDate createDate()
	{
		return LocalDate.now();
	}

	public static void main(String[] args) {
		ApplicationContext cxt= SpringApplication.run(DependencyInjectionApplication.class, args);// IOC Container
		SeasonFinder f=cxt.getBean("seasonFinder",SeasonFinder.class); //get targer bean obj
		
		String season=f.findSeason();
		
		System.out.println();
		System.out.println("The OnGoing Season is =>> "+season);
		((ConfigurableApplicationContext)cxt).close();
	}

}
