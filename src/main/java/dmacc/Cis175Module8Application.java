
package dmacc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Item;
import dmacc.beans.Menu;
import dmacc.beans.Restaurant;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.RestaurantRepository;

@SpringBootApplication
public class Cis175Module8Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Cis175Module8Application.class, args);
	}

	@Autowired
	RestaurantRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		//Using an existing bean
		Restaurant r = appContext.getBean("restaurant", Restaurant.class);
		Menu m = appContext.getBean("menu", Menu.class);
		Item i = appContext.getBean("item", Item.class);
		Item i2 = appContext.getBean("item", Item.class);
		
		i.setName("alfredo");
		i.setPrice(15.99);
		i.setMenu(m);
		i2.setName("linguini");
		i2.setPrice(17.56);
		i2.setMenu(m);
		
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(i);
		itemList.add(i2);
		
		m.setItems(itemList);
		m.setName("dinner");
		
		r.setName("Ralph's");
		r.setMenu(m);
		repo.save(r);
		
		List<Restaurant> allMyRestaurants = repo.findAll();
		for(Restaurant people: allMyRestaurants) {
			System.out.println(people.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
