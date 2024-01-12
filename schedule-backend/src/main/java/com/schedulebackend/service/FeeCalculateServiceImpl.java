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

        BigDecimal feeThree = new BigDecimal("3");

        BigDecimal originalValue = financialTransfer.getTransferAmount();

        BigDecimal threePercent = originalValue.multiply(new BigDecimal("0.03"));

        BigDecimal resultAfterPercent = originalValue.subtract(threePercent);

        BigDecimal resultAfterFee = resultAfterPercent.subtract(feeThree);

        return originalValue.subtract(resultAfterFee);

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
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("1001")) > 0
                && financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) <= 0) {
            return feeCalculationB(financialTransfer);
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) > 0) {
            return feeCalculationC(financialTransfer);
        } else {
            System.out.println("Erro: Valor de transferência inválido");
            return new BigDecimal("0");
        }
    }
}
