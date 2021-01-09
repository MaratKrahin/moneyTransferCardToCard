package com.mtService.service;

import com.mtService.dao.model.Card;
import com.mtService.dto.CardDto;

import java.util.List;

public interface CardService {
    List<Card> getAllForUser(Long userId);

    Card getByNumber(String number);

    Card getById(Long id);

    Card save(Card card);

    Card addMoney(CardDto cardDto);

}
