package com.elyhouadria.acmeinc.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Category implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length= 36)
	private int id;
	@Column(length = 26)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,26}$",
			message = "Please enter a valid name.")
	private String name;

	@Column(columnDefinition = "TEXT",length = 512)
	@Pattern(regexp = "^[A-Za-z0-9 _.,!\"'/$]{10,512}$",
			message = "Please enter a valid description.")
	private String description;

	@Column(length = 2083)
	@URL
	private String imageURL;

	// Managed reference to avoid JSON loop between product and category
	@JsonManagedReference(value = "product_category")
	@OneToMany(mappedBy="category")
	private List<Product> productsInCategory;

}
