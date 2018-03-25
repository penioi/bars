package com.example.bars.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CurrentPriceRepo extends CrudRepository<CurrentPrice, PriceIdentity> {
    Iterable<CurrentPrice> findByBar(Bar barId);
}
