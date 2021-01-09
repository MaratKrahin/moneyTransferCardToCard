package com.mtService.service.impl;

import com.mtService.dao.CardRepository;
import com.mtService.dao.model.Card;
import com.mtService.dto.CardDto;
import com.mtService.service.CardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CardServiceImplTest {

    @MockBean
    CardRepository cardRepository;

    @Autowired
    CardService cardService;

    @Test
    void addMoney() {
        var cardDto = new CardDto();
        var card = Card.builder().balance(BigDecimal.ZERO).build();
        cardDto.setBalance(BigDecimal.valueOf(100L));
        when(cardRepository.findCardByNumber(any())).thenReturn(Optional.of(card));
        cardService.addMoney(cardDto);

        Assertions.assertEquals(BigDecimal.valueOf(100), card.getBalance());
    }
}