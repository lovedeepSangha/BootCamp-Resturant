package com.bootcamp.resturant.service;

import com.bootcamp.resturant.domain.Order;
import com.bootcamp.resturant.domain.OrderStatus;
import com.bootcamp.resturant.service.OrderService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Getter
@Setter
@Service
@NoArgsConstructor
public class ChefService implements Runnable {
    @Autowired
   private OrderService orderService;
    //queue to get order picked up by waiter
   private BlockingQueue<Order> queue;

    @SneakyThrows
    public void run() {
            var order = queue.take();
            // Waiting time for order to prepare
            Thread.sleep(order.getItem().getTimeToPrepare() * 1000);
//            change the status to completed after chef done its job
            orderService.changeOrderStatus(order, OrderStatus.COMPLETED);
    }
}
