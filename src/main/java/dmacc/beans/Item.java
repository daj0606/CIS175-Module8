package dmacc.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author chumb - djackson16 CIS175 - Spring 2024 Mar 13, 2024
 */

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	@ManyToOne
	private Menu menu;

	public Item() {
		super();
	}

	public Item(String name) {
		super();
		this.name = name;
	}

	public Item(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Item(int id, String name, float price, Menu menu) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.menu = menu;
	}

	public Item(String name, float price, Menu menu) {
		super();
		this.name = name;
		this.price = price;
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		String menuName = (this.menu != null) ? menu.getName() : "";
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", menu=" + menuName + "]";
	}
	
}
