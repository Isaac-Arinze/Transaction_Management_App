package com.zikan.transaction_management.repository;

import com.zikan.transaction_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment, Long> {
}
