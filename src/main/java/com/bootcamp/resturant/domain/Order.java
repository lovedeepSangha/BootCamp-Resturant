package com.bootcamp.resturant.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    private Item item;
    @CreationTimestamp
    private LocalDateTime createdOn;
    private OrderStatus orderStatus;


    public Order(Item item) {
        this.item=item;
        this.orderStatus=OrderStatus.PICKED_UP;
    }
}
