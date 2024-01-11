package com.schedulebackend.repository;

import com.schedulebackend.domain.FinancialTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialTransferRepository extends JpaRepository<FinancialTransfer, Long> {
}
