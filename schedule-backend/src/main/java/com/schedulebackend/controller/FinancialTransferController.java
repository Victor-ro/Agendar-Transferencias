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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/financial-transfer")
public class FinancialTransferController {

    @Autowired
    private FinancialTransferService financialTransferService;

    @PostMapping
    public ResponseEntity<FinancialTransfer> createFinancialTransfer(@RequestBody FinancialTransferDTO financialTransferDTO) {

        try {
            FinancialTransfer financialTransfer = financialTransferService.createFinancialTransfer(financialTransferDTO);
            return new ResponseEntity<>(financialTransfer, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao processar a transferência financeira", e);
        }


    }

    @GetMapping
    public ResponseEntity<List<FinancialTransfer>> getAllFinancialTransfer() {
        List<FinancialTransfer> financialTransfers = financialTransferService.getAllFinancialsTransfers();
        return new ResponseEntity<>(financialTransfers, HttpStatus.OK);
    }
}
