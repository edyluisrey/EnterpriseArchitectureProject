package edu.mum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Category {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    String name;
    String description;
    
    // If using a List INSTEAD of a SET - less efficient
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable ( name="Category_Product", joinColumns={@JoinColumn(name="Category_ID")},  
    inverseJoinColumns={ @JoinColumn(name="Product_ID")} )  
    Set<Product> products = new HashSet<Product>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

 	public void addProduct(Product product) {
		this.products.add(product);
//		product.getCategories().add(this);
	}

}
