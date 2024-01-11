package com.schedulebackend.controller;

import com.schedulebackend.domain.FinancialTransfer;
import com.schedulebackend.dto.FinancialTransferDTO;
import com.schedulebackend.service.FinancialTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/financial-transfer")
public class FinancialTransferController {

    @Autowired
    private FinancialTransferService financialTransferService;

    @PostMapping
    public ResponseEntity<FinancialTransfer> createFinancialTransfer(@RequestBody FinancialTransferDTO financialTransferDTO) {
        FinancialTransfer financialTransfer = financialTransferService.createFinancialTransfer(financialTransferDTO);
        return new ResponseEntity<>(financialTransfer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FinancialTransfer>> getAllFinancialTransfer() {
        List<FinancialTransfer> financialTransfers = financialTransferService.getAllFinancialTransfer();
        return new ResponseEntity<>(financialTransfers, HttpStatus.OK);
    }
}
