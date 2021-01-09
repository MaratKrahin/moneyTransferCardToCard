package com.mtService.service.impl;

import com.mtService.dao.CardRepository;
import com.mtService.dao.model.Card;
import com.mtService.dto.CardDto;
import com.mtService.exception.ObjectNotFoundException;
import com.mtService.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllForUser(Long userId) {
        return cardRepository.findAllByUserId(userId);
    }

    @Override
    public Card getByNumber(String number) {
        return cardRepository.findCardByNumber(number)
                .orElseThrow(() -> new ObjectNotFoundException("Card with number " + number + " not found"));
    }

    @Override
    public Card getById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Card with id " + id + " not found"));
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public Card addMoney(CardDto cardDto) {
        var card = getByNumber(cardDto.getNumber());
        card.setBalance(card.getBalance().add(cardDto.getBalance()));
        return save(card);
    }
}
