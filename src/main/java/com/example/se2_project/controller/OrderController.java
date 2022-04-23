package com.example.se2_project.controller;


import com.example.se2_project.model.Orders;
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
    public Orders createOrder(
            @RequestBody Orders orders){
        return orderRepository.save(orders);
    }

    @PutMapping(value = "/order/{id}")
    public void updateOrder(
            @PathVariable(value = "id") Long id,
            @RequestBody Orders orders) {
        if (orderRepository.existsById(id)) {
            orders.setId(id);
            orderRepository.save(orders);
        }
    }

    @DeleteMapping(value="/order/{id}")
    public void deleteOrder(
            @PathVariable(value = "id") Long id) {
        if (orderRepository.existsById(id)) {
            Orders orders = orderRepository.findById(id).get();
            orderRepository.delete(orders);
        }
    }
}
