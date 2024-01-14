package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class FeeCalculateServiceImpl implements FeeCalculateService {


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

        return new BigDecimal("12");

    }

    @Override
    public BigDecimal feeCalculationC(FinancialTransfer financialTransfer) {

        LocalDate transferDate = financialTransfer.getTransferDate();
        LocalDate scheduledDate = financialTransfer.getScheduledDate();

        long daysDifference = DAYS.between(scheduledDate, transferDate);

        if (daysDifference > 40) {
            return financialTransfer.getTransferAmount().multiply(new BigDecimal("0.017"));
        } else if (daysDifference > 30) {
            return financialTransfer.getTransferAmount().multiply(new BigDecimal("0.047"));
        } else if (daysDifference > 20) {
            return financialTransfer.getTransferAmount().multiply(new BigDecimal("0.069"));
        } else if (daysDifference > 10) {
            return financialTransfer.getTransferAmount().multiply(new BigDecimal("0.082"));
        } else {
            System.out.println("Erro: Não há taxa aplicável");
            return BigDecimal.ZERO;
        }
    }

    @Override
    public BigDecimal feeCalculationD(FinancialTransfer financialTransfer) {

        if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("1000")) <= 0) {
            return feeCalculationA(financialTransfer);
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("1001")) >= 0
                && financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) <= 0) {
            return feeCalculationB(financialTransfer);
        } else if (financialTransfer.getTransferAmount().compareTo(new BigDecimal("2000")) > 0) {
            return feeCalculationC(financialTransfer);
        } else {
            System.out.println("Erro: Não há taxa aplicável");
            return BigDecimal.ZERO;
        }
    }

    @Override
    public BigDecimal feeCalculationByDate(FinancialTransfer financialTransfer) {

        LocalDate transferDate = financialTransfer.getTransferDate();
        LocalDate scheduledDate = financialTransfer.getScheduledDate();

        if (transferDate.isEqual(scheduledDate)) {
            return feeCalculationA(financialTransfer);
        } else {
            long daysDifference = ChronoUnit.DAYS.between(scheduledDate, transferDate);

            if (daysDifference > 10) {
                return feeCalculationC(financialTransfer);
            } else {
                return feeCalculationB(financialTransfer);
            }
        }
    }
}
