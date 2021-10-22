package com.bootcamp.resturant.repository;

import com.bootcamp.resturant.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
