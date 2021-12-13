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
}
