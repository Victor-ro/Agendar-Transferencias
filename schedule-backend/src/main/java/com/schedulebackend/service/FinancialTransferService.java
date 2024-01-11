package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;
import com.schedulebackend.dto.FinancialTransferDTO;

import java.util.List;

public interface FinancialTransferService {

    List<FinancialTransfer> getAllFinancialTransfer();

    public FinancialTransfer createFinancialTransfer(FinancialTransferDTO financialTransferDTO);

    public void saveFinancialTransfer(FinancialTransfer financialTransfer);

}
