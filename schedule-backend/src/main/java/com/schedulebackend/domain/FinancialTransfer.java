package com.schedulebackend.domain;

import com.schedulebackend.dto.FinancialTransferDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "financial_transfer")
@Table(name = "financial_transfer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FinancialTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originAccount;

    private String destinationAccount;

    private BigDecimal transferAmount;

    private BigDecimal fee;

    private LocalDate transferDate;

    private LocalDate scheduledDate;

    public FinancialTransfer(FinancialTransferDTO financialTransferDTO) {
        this.originAccount = financialTransferDTO.originAccount();
        this.destinationAccount = financialTransferDTO.destinationAccount();
        this.transferAmount = financialTransferDTO.transferAmount();
        this.fee = financialTransferDTO.fee();
        this.transferDate = financialTransferDTO.transferDate();
        this.scheduledDate = LocalDate.now();
    }

}
