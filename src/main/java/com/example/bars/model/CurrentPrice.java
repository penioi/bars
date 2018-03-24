package com.example.bars.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CurrentPrice {



    @EmbeddedId
    private PriceIdentity priceIdentity = new PriceIdentity();

    @ManyToOne
    @MapsId("barId")
    private Bar bar;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PriceIdentity getPriceIdentity() {
        return priceIdentity;
    }

    public void setPriceIdentity(PriceIdentity priceIdentity) {
        this.priceIdentity = priceIdentity;
    }
}
