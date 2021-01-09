package com.mtService.service.impl;

import com.mtService.dao.model.Card;
import com.mtService.dto.Amount;
import com.mtService.dto.TransferDto;
import com.mtService.exception.BusinessException;
import com.mtService.service.TransferService;
import com.mtService.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceImplTest {

    @MockBean
    CardServiceImpl cardService;

    @Autowired
    TransferService transferService;

    @Test
    void transfer() {
        var transfer = new TransferDto();
        var amount =  new Amount();
        amount.setValue(100L);
        transfer.setAmount(amount);
        transfer.setCardFromNumber("123-123-123");
        transfer.setCardToNumber("22-22-22");

        var card = Card.builder().balance(BigDecimal.valueOf(1000L)).build();
        var card1 = Card.builder().balance(BigDecimal.valueOf(100L)).build();

        when(cardService.getByNumber("123-123-123")).thenReturn(card);
        when(cardService.getByNumber("22-22-22")).thenReturn(card1);
        transferService.transfer(transfer);
    }


    @Test
    void transfer1() {
        var transfer = new TransferDto();
        var amount =  new Amount();
        amount.setValue(10000L);
        transfer.setAmount(amount);
        transfer.setCardFromNumber("123-123-123");
        transfer.setCardToNumber("22-22-22");

        var card = Card.builder().balance(BigDecimal.valueOf(1000L)).build();
        var card1 = Card.builder().balance(BigDecimal.valueOf(100L)).build();

        when(cardService.getByNumber("123-123-123")).thenReturn(card);
        when(cardService.getByNumber("22-22-22")).thenReturn(card1);
        Assertions.assertThrows(BusinessException.class, () -> transferService.transfer(transfer));
    }
}