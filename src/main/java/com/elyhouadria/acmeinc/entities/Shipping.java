package com.elyhouadria.acmeinc.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Shipping implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    private int id;
    @Column(length = 48)
    @Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,48}$",
            message = "Please enter a valid name.")
    private String shippingName;
    @Column(length = 11)
    @Pattern(regexp = "^\\d+(,\\d{1,2})?$",
            message = "Please enter a valid price.")
    private Double shippingPrice;


    @JsonIgnore
    @OneToMany(mappedBy = "shipping")
    private List<UserOrder> userorder;

    public Shipping() {
    }

    public Shipping(String shippingName, Double shippingPrice) {
        this.shippingName = shippingName;
        this.shippingPrice = shippingPrice;
    }

    public Shipping(int id, String shippingName, Double shippingPrice) {
        this.id = id;
        this.shippingName = shippingName;
        this.shippingPrice = shippingPrice;
    }

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(Double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public UserOrder getUserOrder() {
		return userorder;
	}

	public void setUserOrder(UserOrder userorder) {
		this.userorder = userorder;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public UserOrder getUserorder() {
		return userorder;
	}

	public void setUserorder(UserOrder userorder) {
		this.userorder = userorder;
	}

	@Override
	public String toString() {
		return id + ", " + shippingName + ", " + shippingPrice;
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
		Shipping other = (Shipping) obj;
		if (id != other.id)
			return false;
		return true;
	}
	*/
}
