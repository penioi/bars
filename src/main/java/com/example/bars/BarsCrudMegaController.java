package com.example.bars;

import com.example.bars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BarsCrudMegaController {

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


    @RequestMapping(value = "bar/{id}", method = RequestMethod.GET)
    public Bar getBar(@PathVariable(name = "id") Long id) {
        return barRepo.findById(id).get();
    }

    @RequestMapping(value = "bar", method = RequestMethod.GET)
    public List<Bar> getBar() {
        List<Bar> bars = new ArrayList<>();
        barRepo.findAll().forEach(c -> bars.add(c));
        return bars;
    }

    @RequestMapping(value = "bar", method = RequestMethod.POST)
    public Bar saveBar(Bar bar) {
        return barRepo.save(bar);
    }

    @RequestMapping(value = "bar/{id}", method = RequestMethod.DELETE)
    public String removeBar(@PathVariable(name="id") Long id) {
        Bar bar = barRepo.findById(id).get();
        barRepo.delete(bar);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productRepo.findById(id).get();
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(c -> products.add(c));
        return products;
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public String removeProduct(@PathVariable(name="id") Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "currentPrice/{compositeId}", method = RequestMethod.GET)
    public CurrentPrice getCurrentPrice(@PathVariable(name = "compositeId") String compositeId) {
        String[] ids = compositeId.split(" ");
        PriceIdentity priceIdentity = new PriceIdentity();
        priceIdentity.setBarId(Long.valueOf(ids[0]));
        priceIdentity.setProductId(Long.valueOf(ids[1]));

        return currentPriceRepo.findById(priceIdentity).get();
    }

    @RequestMapping(value = "currentPrice", method = RequestMethod.GET)
    public List<CurrentPrice> getCurrentPrice() {
        List<CurrentPrice> currentPrices = new ArrayList<>();
        currentPriceRepo.findAll().forEach(c -> currentPrices.add(c));
        return currentPrices;
    }

    @RequestMapping(value = "currentPrice", method = RequestMethod.POST)
    public CurrentPrice saveCurrentPrice(CurrentPrice currentPrice) {
        return currentPriceRepo.save(currentPrice);
    }

    @RequestMapping(value = "currentPrice/{compositeId}", method = RequestMethod.DELETE)
    public String removeCurrentPrice(@PathVariable(name = "compositeId") String compositeId) {
        String[] ids = compositeId.split(" ");
        PriceIdentity priceIdentity = new PriceIdentity();
        priceIdentity.setBarId(Long.valueOf(ids[0]));
        priceIdentity.setProductId(Long.valueOf(ids[1]));
        CurrentPrice currentPrice = currentPriceRepo.findById(priceIdentity).get();
        currentPriceRepo.delete(currentPrice);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "orderedBeverage/{id}", method = RequestMethod.GET)
    public OrderedBeverage getOrderedBeverage(@PathVariable(name = "id") Long id) {
        return orderedBeverageRepo.findById(id).get();
    }

    @RequestMapping(value = "orderedBeverage", method = RequestMethod.GET)
    public List<OrderedBeverage> getOrderedBeverage() {
        List<OrderedBeverage> orderedBeverages = new ArrayList<>();
        orderedBeverageRepo.findAll().forEach(c -> orderedBeverages.add(c));
        return orderedBeverages;
    }

    @RequestMapping(value = "orderedBeverage", method = RequestMethod.POST)
    public OrderedBeverage saveOrderedBeverage(OrderedBeverage orderedBeverage) {
        return orderedBeverageRepo.save(orderedBeverage);
    }

    @RequestMapping(value = "orderedBeverage/{id}", method = RequestMethod.DELETE)
    public String removeOrderedBeverage(@PathVariable(name="id") Long id) {
        OrderedBeverage orderedBeverage = orderedBeverageRepo.findById(id).get();
        orderedBeverageRepo.delete(orderedBeverage);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "round/{id}", method = RequestMethod.GET)
    public Round getRound(@PathVariable(name = "id") Long id) {
        return roundRepo.findById(id).get();
    }

    @RequestMapping(value = "round", method = RequestMethod.GET)
    public List<Round> getRound() {
        List<Round> rounds = new ArrayList<>();
        roundRepo.findAll().forEach(c -> rounds.add(c));
        return rounds;
    }

    @RequestMapping(value = "round", method = RequestMethod.POST)
    public Round saveRound(Round round) {
        return roundRepo.save(round);
    }

    @RequestMapping(value = "round/{id}", method = RequestMethod.DELETE)
    public String removeRound(@PathVariable(name="id") Long id) {
        Round round = roundRepo.findById(id).get();
        roundRepo.delete(round);
        return "SUCCESS";//here all needs serious revamp
    }


}
