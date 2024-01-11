package com.schedulebackend.service;

import com.schedulebackend.domain.FinancialTransfer;
import com.schedulebackend.dto.FinancialTransferDTO;
import com.schedulebackend.repository.FinancialTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class FinancialTransferServiceImpl implements FinancialTransferService {

    @Autowired
    private FinancialTransferRepository financialTransferRepository;

    @Override
    public List<FinancialTransfer> getAllFinancialTransfer() {
        return financialTransferRepository.findAll();
    }

    @Override
    public FinancialTransfer createFinancialTransfer(FinancialTransferDTO financialTransferDTO) {
        FinancialTransfer financialTransfer = new FinancialTransfer(financialTransferDTO);
        financialTransfer.setFee(new BigDecimal("123.456"));
        saveFinancialTransfer(financialTransfer);
        return financialTransfer;
    }

    @Override
    public void saveFinancialTransfer(FinancialTransfer financialTransfer){
        financialTransferRepository.save(financialTransfer);
    }
}
