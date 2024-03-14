package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dmacc.beans.Item;
import dmacc.beans.Menu;
import dmacc.beans.Restaurant;

@Configuration
public class BeanConfiguration {

	@Bean
	public Restaurant restaurant() {
		Restaurant bean = new Restaurant();

		return bean;
	}

	@Bean
	public Menu menu() {
		Menu bean = new Menu();
		
		return bean;
	}
	
	@Bean 
	@Scope("prototype")
	public Item item() {
		Item bean = new Item();
		
		return bean;
	}
}
