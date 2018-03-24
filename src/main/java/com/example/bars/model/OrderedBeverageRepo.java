package com.example.bars.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderedBeverageRepo extends CrudRepository<OrderedBeverage, Long> {
}
