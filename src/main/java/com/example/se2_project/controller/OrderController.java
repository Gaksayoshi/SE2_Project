package com.example.se2_project.controller;


import com.example.se2_project.model.Order;
import com.example.se2_project.repository.CartRepository;
import com.example.se2_project.repository.OrderRepository;
import com.example.se2_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value = "/order")
    public Order createOrder(
            @RequestBody Order order){
        return orderRepository.save(order);
    }

    @PutMapping(value = "/order/{id}")
    public void updateOrder(
            @PathVariable(value = "id") Long id,
            @RequestBody Order order) {
        if (orderRepository.existsById(id)) {
            orderRepository.setId(id);
            orderRepository.save(order);
        }
    }

    @DeleteMapping(value="/order/{id}")
    public void deleteOrder(
            @PathVariable(value = "id") Long id) {
        if (orderRepository.existsById(id)) {
            Order order = orderRepository.findById(id).get();
            orderRepository.delete(order);
        }
    }
}
