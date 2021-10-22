package com.bootcamp.resturant.dto;

import com.bootcamp.resturant.domain.Order;
import com.bootcamp.resturant.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusDTO {


    private Integer id;
    private OrderStatus orderStatus;

    public OrderStatusDTO(Order order) {
        this.id = order.getId();
        this.orderStatus = order.getOrderStatus();
    }

    public OrderStatusDTO() {
        this.orderStatus=OrderStatus.INVALID;
    }
}
