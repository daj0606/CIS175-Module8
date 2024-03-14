package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author chumb - djackson16
 * CIS175 - Spring 2024
 * Mar 13, 2024
 */
@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "restaurantname")
	private String name;
	@ManyToOne(targetEntity = Menu.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Menu menu;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String name) {
		super();
		this.name = name;
	}
	
	public Restaurant(String name, Menu menu) {
		super();
		this.name = name;
		this.menu = menu;
	}

	public Restaurant(int id, String name, Menu menu) {
		super();
		this.id = id;
		this.name = name;
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", menu=" + menu + "]";
	}
	
}
