package com.mtService.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDto {
    private String number;
    private BigDecimal balance;
}
