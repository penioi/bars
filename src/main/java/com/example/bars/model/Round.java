package com.example.bars.model;

import javax.persistence.*;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bar_id")
    private Bar bar;

    @OneToMany(mappedBy = "round", cascade =  CascadeType.PERSIST)
    private Collection<OrderedBeverage> orderedBeverages;

    private Date orderedAt;

    private BigDecimal totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Collection<OrderedBeverage> getOrderedBeverages() {
        return orderedBeverages;
    }

    public void setOrderedBeverages(Collection<OrderedBeverage> orderedBeverages) {
        this.orderedBeverages = orderedBeverages;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
