package com.mtService.dao.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
public class Card {
    @Id
    private Long id;
    private Long userId;
    private String number;
    private BigDecimal balance;
}
