package com.bootcamp.resturant.service;

import com.bootcamp.resturant.domain.Order;
import com.bootcamp.resturant.domain.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

@Service
public class WaiterService {


    @Autowired
    private OrderService orderService;
    @Autowired
    private ChefService chefService;
    // to maintain queue for  order
    private BlockingQueue<Order> queue = new ArrayBlockingQueue<Order>(1000);
    // to run single thread
    private ExecutorService pool = Executors.newSingleThreadExecutor();

    @KafkaListener(topics = "order", containerFactory = "kafkaListenerContainerFactory")
    public void WaiterAcceptingOrder(Order order) throws InterruptedException {
        orderService.changeOrderStatus(order, OrderStatus.PICKED_UP);
        queue.put(order);
        chefService.setQueue(queue);
        pool.submit(chefService);

    }


}

