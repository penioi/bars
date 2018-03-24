package com.example.bars.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderedBeverage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    private BigDecimal acutalPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public BigDecimal getAcutalPrice() {
        return acutalPrice;
    }

    public void setAcutalPrice(BigDecimal acutalPrice) {
        this.acutalPrice = acutalPrice;
    }
}
