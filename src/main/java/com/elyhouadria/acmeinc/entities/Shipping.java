package com.elyhouadria.acmeinc.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(length = 7)
    @NotNull
    private Double shippingPrice;


    @JsonIgnore
    @OneToMany(mappedBy = "shipping")
    private List<UserOrder> userOrder;

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
}
