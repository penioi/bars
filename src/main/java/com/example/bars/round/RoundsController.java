package com.example.bars.round;

import com.example.bars.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class RoundsController {

    @Autowired
    private BarRepo barRepo;

    @Autowired
    private OrderedBeverageRepo orderedBeverageRepo;

    @Autowired
    private CurrentPriceRepo currentPriceRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RoundRepo roundRepo;



    @PostMapping(path = "/placeRound")
    public ResponseEntity<Round> placeOrder(@RequestBody PlaceRoundRequest placeRoundRequest){
        Round round = new Round();
        round.setBar(barRepo.findById(placeRoundRequest.getBarId()).get());
        roundRepo.save(round);
        round.setOrderedAt( new Date());
        List<OrderedBeverage> order = StreamSupport.stream(placeRoundRequest.getOrderedProducts().spliterator(), false)
                .map(op ->{
                        OrderedBeverage ob = new OrderedBeverage();
                        ob.setQuantity(op.getQuantity());
                        ob.setProduct(productRepo.findById(op.getProductId()).get());
                        ob.setRound(round);
                        ob.setAcutalPrice(
                                currentPriceRepo.findById(new PriceIdentity(round.getBar().getId(), op.getProductId())).get().getPrice().multiply(BigDecimal.valueOf(op.getQuantity()))
                        );
                        orderedBeverageRepo.save(ob);
                        return ob;
                } ) .collect(Collectors.toList());

        round.setOrderedBeverages(order);
        roundRepo.save(round);
        return new ResponseEntity<Round>(round, HttpStatus.CREATED);
    }

}
