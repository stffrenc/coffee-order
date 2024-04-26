package edu.iu.stffrenc.coffeeorder.controllers;

import edu.iu.stffrenc.coffeeorder.model.OrderData;
import edu.iu.stffrenc.coffeeorder.model.Receipt;
import edu.iu.stffrenc.coffeeorder.repository.OrderFileRepository;
import edu.iu.stffrenc.coffeeorder.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody OrderData order) {
        try {
            orderRepository.save(order);
            Receipt receipt = OrderFileRepository.add(order);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(receipt);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
