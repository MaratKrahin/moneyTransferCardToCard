package com.mtService.controllers;

import com.mtService.dto.CardDto;
import com.mtService.mapping.CardMapper;
import com.mtService.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping("/{userId}")
    @Operation(summary = "Вывести список карт пользователя")
    public ResponseEntity<List<CardDto>> cards(@PathVariable Long userId) {
        log.info("Список карт для пользователя с ID: " + userId);
        return ResponseEntity.ok(cardMapper.toDto(cardService.getAllForUser(userId)));
    }

    @PostMapping("/{number}")
    @Operation(summary = "Пополнение карты")
    public ResponseEntity addMoney(@RequestBody CardDto cardDto) {
        log.info("Карта " + cardDto.getNumber() + " пополнена, баланс карты: " + cardDto.getBalance());
        cardService.addMoney(cardDto);
        return ResponseEntity.ok().build();
    }
}
