package com.example.webuy.core.deal;

import com.example.webuy.core.comment.Comment;
import com.example.webuy.core.pourshaseGroup.PurshaseGroup;
import com.example.webuy.core.product.Product;
import com.example.webuy.core.store.Store;
import com.example.webuy.core.user.User;
import com.example.webuy.core.utils.BaseWebuy;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;


public class Deal extends BaseWebuy implements Serializable {


    private double price_before_promo;
    private double price_promo;
    private int quantity_min_to_Buy, quantity_available;
    private Store stores;
    private Product product;
    private PurshaseGroup purshaseGroup;
    private long userLike, userDislike;
    private Timestamp createdAt, startedAt, endedAt;
    private User user;
    private ArrayList<Comment> comments;

    public static ArrayList<Deal> getAllDeals() {
        //API TODO

        return new ArrayList<Deal>();
    }



    public double getPrice_before_promo() {
        return price_before_promo;
    }

    public void setPrice_before_promo(double price_before_promo) {
        this.price_before_promo = price_before_promo;
    }

    public double getPrice_promo() {
        return price_promo;
    }

    public void setPrice_promo(double price_promo) {
        this.price_promo = price_promo;
    }

    public int getQuantity_min_to_Buy() {
        return quantity_min_to_Buy;
    }

    public void setQuantity_min_to_Buy(int quantity_min_to_Buy) {
        this.quantity_min_to_Buy = quantity_min_to_Buy;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public Store getStores() {
        return stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurshaseGroup getPurshaseGroup() {
        return purshaseGroup;
    }

    public void setPurshaseGroup(PurshaseGroup purshaseGroup) {
        this.purshaseGroup = purshaseGroup;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public long getUserLike() {
        return userLike;
    }

    public void setUserLike(long userLike) {
        this.userLike = userLike;
    }

    public long getUserDislike() {
        return userDislike;
    }

    public void setUserDislike(long userDislike) {
        this.userDislike = userDislike;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Timestamp endedAt) {
        this.endedAt = endedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "price_before_promo=" + price_before_promo +
                ", price_promo=" + price_promo +
                ", quantity_min_to_Buy=" + quantity_min_to_Buy +
                ", quantity_available=" + quantity_available +
                ", stores=" + stores +
                ", product=" + product +
                ", purshaseGroup=" + purshaseGroup +
                ", userLike=" + userLike +
                ", userDislike=" + userDislike +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
