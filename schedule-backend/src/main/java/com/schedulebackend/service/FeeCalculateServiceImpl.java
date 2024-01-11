package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;
import com.schedulebackend.repository.FinancialTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class FeeCalculateServiceImpl implements FeeCalculateService {

    @Autowired
    private FinancialTransferRepository financialRepository;

    @Override
    public BigDecimal feeCalculationA(FinancialTransfer financialTransfer) {
        System.out.println("O valor é até 1000");
        return null;
    }

    @Override
    public BigDecimal feeCalculationB(FinancialTransfer financialTransfer) {
        System.out.println("O valor é entre 1001 e 2000");
        return null;
    }

    @Override
    public BigDecimal feeCalculationC(FinancialTransfer financialTransfer) {
        System.out.println("O valor é entre 2001 e 3000");
        return null;
    }

    @Override
    public BigDecimal feeCalculationD(FinancialTransfer financialTransfer) {

        if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("1000")) <= 0) {
            return feeCalculationA(financialTransfer);
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) <= 0) {
            return feeCalculationB(financialTransfer);
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) > 0) {
            return feeCalculationC(financialTransfer);
        }

        return null;
    }
}
