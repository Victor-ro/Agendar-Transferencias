package com.schedulebackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "financial_transfer")
@Table(name = "financial_transfer")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FinancialTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originAccount;

    private String destinationAccount;

    private BigDecimal transferAmount;

    private BigDecimal fee;

    private LocalDateTime transferDate;

    private LocalDateTime scheduledDate;

}
