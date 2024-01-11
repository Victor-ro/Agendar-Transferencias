package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;
import com.schedulebackend.repository.FinancialTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FinancialTransferServiceImpl implements FinancialTransferService {

    @Autowired
    private FinancialTransferRepository financialRepository;

    @Override
    public BigDecimal feeCalculationA(FinancialTransfer financialTransfer) {
        return null;
    }

    @Override
    public BigDecimal feeCalculationB(FinancialTransfer financialTransfer) {
        return null;
    }

    @Override
    public BigDecimal feeCalculationC(FinancialTransfer financialTransfer) {
        return null;
    }

    @Override
    public BigDecimal feeCalculationD(FinancialTransfer financialTransfer) {
        return null;
    }
}
