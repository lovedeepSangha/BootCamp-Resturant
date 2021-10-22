package com.bootcamp.resturant.controller;

import com.bootcamp.resturant.domain.OrderStatus;
import com.bootcamp.resturant.dto.OrderStatusDTO;
import com.bootcamp.resturant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderStatusDTO placeOrder(@RequestParam  Integer itemId) {
        return orderService.placeOrder(itemId);
    }

    @GetMapping
    public OrderStatusDTO getStatusOfOrder(@RequestParam Integer orderId){
        return orderService.checkOrderStatus(orderId);
    }

}
