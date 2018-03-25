package com.example.bars;

import com.example.bars.model.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class BarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarsApplication.class, args);
    }

    @Autowired
    private BarRepo barRepo;

    @Autowired
    private CurrentPriceRepo currentPriceRepo;

    @Autowired
    private OrderedBeverageRepo orderedBeverageRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RoundRepo roundRepo;


    //
    @EventListener(ApplicationReadyEvent.class)
    void initSomeData() {
        initBars();
        initProducts();
        initCurrnetPrice();
        initRounds();
        initOrderedBeverage();
    }

    private void initBars() {
        Bar bar = new Bar();
        bar.setImgageUrl("https://goo.gl/maps/BpYvxubFY2D2");
        bar.setName("The bar at the end of the universe");
        bar.setLat(new BigDecimal("48.8607105"));
        bar.setLon(new BigDecimal("2.3057088"));
        barRepo.save(bar);

        bar = new Bar();
        bar.setImgageUrl("http://static.tumblr.com/4c3258467f8af35cbd10c121e0200a96/ms8ee2t/PZKmfvqr9/tumblr_static_header.png");
        bar.setName("Feel Like Home");
        bar.setLat(new BigDecimal("48.8607105"));
        bar.setLon(new BigDecimal("2.3057088"));
        barRepo.save(bar);

        bar = new Bar();
        bar.setImgageUrl("http://i2.wp.com/almostveggiehouston.com/wp-content/uploads/2010/10/bar-long-764x1024.jpg?fit=298%2C400");
        bar.setName("I came by myself");
        bar.setLat(new BigDecimal("48.8607105"));
        bar.setLon(new BigDecimal("2.3057088"));
        barRepo.save(bar);
        bar = new Bar();
        bar.setImgageUrl("https://www.abouttimemagazine.co.uk/wp-content/uploads/2017/05/The-Mint-Bar-Westin-Dublin-City-Centre-Mixologist-Drink.jpg");
        bar.setName("Jack, my best friend");
        bar.setLat(new BigDecimal("48.8607105"));
        bar.setLon(new BigDecimal("2.3057088"));
        barRepo.save(bar);
    }

    private void initProducts() {
        Product product = new Product();
        product.setName("Leffe");
        product.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDyiHPdkHZ_lhqQZ8NQpASkg784HyQZfGZAJDO6SBLoCHlkP1m");
        productRepo.save(product);

        product = new Product();
        product.setName("Budweiser");
        product.setImageUrl("https://www.drinksupermarket.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/b/u/budweiser-premium-american-lager-beer-12-x-660-ml_temp.jpg");
        productRepo.save(product);
    }


    private void initCurrnetPrice() {
        StreamSupport.stream(barRepo.findAll().spliterator(), false).forEach(bar -> {
            StreamSupport.stream(productRepo.findAll().spliterator(), false).forEach(p -> {
                CurrentPrice cp = new CurrentPrice();
                cp.setBar(bar);
                cp.setProduct(p);
                cp.setPrice(new BigDecimal(4 + (5 * new Random().nextDouble())));
                currentPriceRepo.save(cp);
            });
        });

    }


    private void initRounds() {
        StreamSupport.stream(barRepo.findAll().spliterator(), false).map(b -> {
            Round round = new Round();
            round.setBar(b);
            round.setOrderedAt(new Date());
            return round;
        }).forEach(r -> roundRepo.save(r));
    }


    private void initOrderedBeverage() {
        StreamSupport.stream(roundRepo.findAll().spliterator(), false).map(round -> {
            OrderedBeverage ob = new OrderedBeverage();
            ob.setRound(round);
            ob.setAcutalPrice(new BigDecimal(10 + (20 * new Random().nextDouble())));
            return ob;
        }).forEach(ob -> orderedBeverageRepo.save(ob));
    }


}
