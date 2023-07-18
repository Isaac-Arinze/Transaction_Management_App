package com.zikan.transaction_management.repository;

import com.zikan.transaction_management.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
