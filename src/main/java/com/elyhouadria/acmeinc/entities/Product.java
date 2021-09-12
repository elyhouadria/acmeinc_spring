package com.elyhouadria.acmeinc.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Product implements Serializable {

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length= 36)
	private int id;
	@Column(length = 48)
	@Pattern(regexp = "^[a-zA-Z0-9àáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,48}$",
			message = "Please enter a valid name.")
	private String productName;
	@Column(columnDefinition = "TEXT",length = 512)
	@Pattern(regexp = "^[A-Za-z0-9 _.,!\"'/$]{10,512}$",
			message = "Please enter a valid description.")
	private String productDescription;
	@Column(length= 10)
	@NotNull
	private Double productPrice;
	@URL
	@Column(length = 2083)
	private String imageURL;

	@JsonBackReference(value = "product_category")
	@ManyToOne
	@JoinColumn(name = "fk_categoryid")
	private Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<OrderLine> productOrderLines;

	public Product() {}

	public Product(String productName, String productDescription, Double productPrice, String imageURL,
			Category category) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imageURL = imageURL;
		this.category = category;
	}

	public Product(int id, String productName, String productDescription, Double productPrice,
			String imageURL, Category category) {
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.imageURL = imageURL;
		this.category = category;
	}

/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderLine> getProductOrderLines() {
		return productOrderLines;
	}

	public void setProductOrderLines(List<OrderLine> productOrderLines) {
		this.productOrderLines = productOrderLines;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return id + ", " + productName;
//		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
*/

}
