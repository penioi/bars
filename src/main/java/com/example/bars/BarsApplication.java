package com.example.bars;

import com.example.bars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.util.Date;

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
		Bar bar = new Bar();
		bar.setImgageUrl("https://goo.gl/maps/BpYvxubFY2D2");
		bar.setName("The bar at the end of the universe");
		bar.setLat(new BigDecimal("48.8607105"));
		bar.setLon(new BigDecimal("2.3057088"));
		barRepo.save(bar);
		initProducts();
		initCurrnetPrice();
		initRounds();
		initOrderedBeverage();
	}

	private void initProducts(){
		Product product = new Product();
		product.setName("Leffe");
		product.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDyiHPdkHZ_lhqQZ8NQpASkg784HyQZfGZAJDO6SBLoCHlkP1m");
		productRepo.save(product);
	}


	private void initCurrnetPrice(){
		CurrentPrice cp = new CurrentPrice();
		cp.setBar(barRepo.findById(1L).get());
		cp.setProduct(productRepo.findAll().iterator().next());
		cp.setPrice(new BigDecimal("5.50"));
		currentPriceRepo.save(cp);
	}


	private void initRounds() {
		Round round = new Round();
		round.setBar(barRepo.findAll().iterator().next());
		round.setOrderedAt(new Date());
		roundRepo.save(round);
	}


	private void initOrderedBeverage(){
		OrderedBeverage orderedBeverage = new OrderedBeverage();
		orderedBeverage.setAcutalPrice(new BigDecimal("11.00"));
		orderedBeverage.setRound(roundRepo.findAll().iterator().next());
		orderedBeverageRepo.save(orderedBeverage);
	}


}
