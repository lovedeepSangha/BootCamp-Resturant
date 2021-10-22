package com.bootcamp.resturant.service;

import com.bootcamp.resturant.domain.Order;
import com.bootcamp.resturant.domain.OrderStatus;
import com.bootcamp.resturant.dto.OrderStatusDTO;
import com.bootcamp.resturant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderService {


    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderStatusDTO placeOrder(Integer itemId) {
        var item = itemService.findItemById(itemId);
        if (item.isPresent()) {
            Order order = orderRepository.save(new Order(item.orElseThrow()));
            kafkaTemplate.send("order", order);
            return new OrderStatusDTO(order);
        }
        return new OrderStatusDTO();
    }


    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

    }

    public OrderStatusDTO checkOrderStatus(Integer orderId) {
        var order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return new OrderStatusDTO(order.orElseThrow());
        }
        return new OrderStatusDTO();
    }
}
