package com.elyhouadria.acmeinc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reviewString;
    private int rating;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "fk_productid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_userid")
    private User user;

    public Review() {
    }

    public Review(String reviewString, int rating, Date creationDate) {
        this.creationDate=creationDate;
        this.reviewString = reviewString;
        this.rating = rating;
    }

    public Review(String reviewString, int rating, Date creationDate,User user, Product product) {
        this.creationDate=creationDate;
        this.reviewString = reviewString;
        this.rating = rating;
        this.user = user;
        this.product = product;
    }

    public Review(int id, String reviewString, int rating, Date creationDate,User user, Product product) {
        this.id = id;
        this.reviewString = reviewString;
        this.rating = rating;
        this.creationDate=creationDate;
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewString() {
        return reviewString;
    }

    public void setReviewString(String reviewString) {
        this.reviewString = reviewString;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return id + ", " + reviewString + ", " + rating + ", " + product + ", " + user;
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
        Review other = (Review) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
