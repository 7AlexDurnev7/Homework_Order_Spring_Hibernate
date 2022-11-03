package com.order.homework_order_spring.service;

import com.order.homework_order_spring.db.OrderEntity;
import com.order.homework_order_spring.db.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/ping")
    public @ResponseBody String ping() {
        return "pong";
    }

    // CREATE
    @PostMapping(path = "/add")
    private @ResponseBody String addNewOrder(@RequestParam String name, @RequestParam String email,
                                             @RequestParam String phone, @RequestParam String address) {
        OrderEntity order = new OrderEntity();
        order.setName(name);
        order.setEmail(email);
        order.setPhone(phone);
        order.setAddress(address);
        orderRepository.save(order);
        return "Saved";
    }

    //READ
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    //UPDATE
    

    //DELETE
    @PostMapping(path = "/remove")
    public @ResponseBody String removeOrder(@RequestParam Integer id) {
        Optional<OrderEntity> deleted = orderRepository.findById(id);
        if(deleted.isPresent()) {
            orderRepository.delete(deleted.get());
            return "Order " + deleted.get() + " deleted ";
        }
        return "Order with id " + id + " is not exists";
    }

}
