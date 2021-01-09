package com.mtService.service.impl;

import com.mtService.dto.TransferDto;
import com.mtService.exception.BusinessException;
import com.mtService.service.CardService;
import com.mtService.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final CardService cardService;

    @Override
    @Transactional
    public void transfer(TransferDto transferDto) {
        var cardFrom = cardService.getByNumber(transferDto.getCardFromNumber());
        var cardTo = cardService.getByNumber(transferDto.getCardToNumber());
        var res = cardFrom.getBalance().compareTo(BigDecimal.valueOf(transferDto.getAmount().getValue()));
        if(res == 0 || res == 1){
            cardFrom.setBalance(cardFrom.getBalance().subtract(BigDecimal.valueOf(transferDto.getAmount().getValue())));
            cardTo.setBalance(cardTo.getBalance().add(BigDecimal.valueOf(transferDto.getAmount().getValue())));
            cardService.save(cardFrom);
            cardService.save(cardTo);
        }else {
            throw new BusinessException("недостаточно средств");
        }
    }
}
