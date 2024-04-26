package edu.iu.stffrenc.coffeeorder.repository;

import edu.iu.stffrenc.coffeeorder.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByUsername(String username);
}


