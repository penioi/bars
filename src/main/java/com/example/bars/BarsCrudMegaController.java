package com.example.bars;

import com.example.bars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "bars/{id}", method = RequestMethod.GET)
    public Bar getBar(@PathVariable(name = "id") Long id) {
        return barRepo.findById(id).get();
    }

    @RequestMapping(value = "bars", method = RequestMethod.GET)
    public List<Bar> getBars() {
        List<Bar> bars = new ArrayList<>();
        barRepo.findAll().forEach(c -> bars.add(c));
        return bars;
    }

    @RequestMapping(value = "bars", method = RequestMethod.POST)
    public Bar saveBar(@RequestBody Bar bar) {
        return barRepo.save(bar);
    }

    @RequestMapping(value = "bars/{id}", method = RequestMethod.DELETE)
    public String removeBar(@PathVariable(name="id") Long id) {
        Bar bar = barRepo.findById(id).get();
        barRepo.delete(bar);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productRepo.findById(id).get();
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(c -> products.add(c));
        return products;
    }

    @RequestMapping(value = "products", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public String removeProduct(@PathVariable(name="id") Long id) {
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "currentPrices/{compositeId}", method = RequestMethod.GET)
    public CurrentPrice getCurrentPrices(@PathVariable(name = "compositeId") String compositeId) {
        String[] ids = compositeId.split(" ");
        PriceIdentity priceIdentity = new PriceIdentity();
        priceIdentity.setBarId(Long.valueOf(ids[0]));
        priceIdentity.setProductId(Long.valueOf(ids[1]));

        return currentPriceRepo.findById(priceIdentity).get();
    }

    @RequestMapping(value = "currentPrices", method = RequestMethod.GET)
    public List<CurrentPrice> getCurrentPrices() {
        List<CurrentPrice> currentPrices = new ArrayList<>();
        currentPriceRepo.findAll().forEach(c -> currentPrices.add(c));
        return currentPrices;
    }

    @RequestMapping(value = "currentPrices", method = RequestMethod.POST)
    public CurrentPrice saveCurrentPrice(@RequestBody CurrentPrice currentPrice) {
        return currentPriceRepo.save(currentPrice);
    }

    @RequestMapping(value = "currentPrices/{compositeId}", method = RequestMethod.DELETE)
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
    @RequestMapping(value = "orderedBeverages/{id}", method = RequestMethod.GET)
    public OrderedBeverage getOrderedBeverage(@PathVariable(name = "id") Long id) {
        return orderedBeverageRepo.findById(id).get();
    }

    @RequestMapping(value = "orderedBeverages", method = RequestMethod.GET)
    public List<OrderedBeverage> getOrderedBeverages() {
        List<OrderedBeverage> orderedBeverages = new ArrayList<>();
        orderedBeverageRepo.findAll().forEach(c -> orderedBeverages.add(c));
        return orderedBeverages;
    }

    @RequestMapping(value = "orderedBeverages", method = RequestMethod.POST)
    public OrderedBeverage saveOrderedBeverage(@RequestBody OrderedBeverage orderedBeverage) {
        return orderedBeverageRepo.save(orderedBeverage);
    }

    @RequestMapping(value = "orderedBeverages/{id}", method = RequestMethod.DELETE)
    public String removeOrderedBeverage(@PathVariable(name="id") Long id) {
        OrderedBeverage orderedBeverage = orderedBeverageRepo.findById(id).get();
        orderedBeverageRepo.delete(orderedBeverage);
        return "SUCCESS";//here all needs serious revamp
    }

    //---------------------------------------------------------------------------------//
    @RequestMapping(value = "rounds/{id}", method = RequestMethod.GET)
    public Round getRound(@PathVariable(name = "id") Long id) {
        return roundRepo.findById(id).get();
    }

    @RequestMapping(value = "rounds", method = RequestMethod.GET)
    public List<Round> getRound() {
        List<Round> rounds = new ArrayList<>();
        roundRepo.findAll().forEach(c -> rounds.add(c));
        return rounds;
    }

    @RequestMapping(value = "rounds", method = RequestMethod.POST)
    public Round saveRound(@RequestBody Round round) {
        return roundRepo.save(round);
    }

    @RequestMapping(value = "rounds/{id}", method = RequestMethod.DELETE)
    public String removeRound(@PathVariable(name="id") Long id) {
        Round round = roundRepo.findById(id).get();
        roundRepo.delete(round);
        return "SUCCESS";//here all needs serious revamp
    }


}
