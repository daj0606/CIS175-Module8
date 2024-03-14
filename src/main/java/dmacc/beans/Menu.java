package dmacc.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * @author chumb - djackson16
 * CIS175 - Spring 2024
 * Mar 13, 2024
 */
@Entity
public class Menu {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Item> items;
	
	public Menu() {
		super();
	}
	
	public Menu(String name) {
		super();
		this.name = name;
	}
	
	public Menu(String name, List<Item> items) {
		super();
		this.name = name;
		this.items = items;
	}
	
	public Menu(int id, String name, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
	
}
