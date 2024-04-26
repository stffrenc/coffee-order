package edu.iu.stffrenc.coffeeorder.repository;

import edu.iu.stffrenc.coffeeorder.model.OrderData;
import edu.iu.stffrenc.coffeeorder.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderData, Integer> {
}
