package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;

import java.math.BigDecimal;

public interface FeeCalculateService {

    public BigDecimal feeCalculationA(FinancialTransfer financialTransfer);

    public BigDecimal feeCalculationB(FinancialTransfer financialTransfer);

    public BigDecimal feeCalculationC(FinancialTransfer financialTransfer);

    public BigDecimal feeCalculationD(FinancialTransfer financialTransfer);

}
