package com.mtService.controllers;

import com.mtService.dto.TransferDto;
import com.mtService.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    @Operation(summary = "Перевод денег с карты на карту")
    public ResponseEntity transfer(@RequestBody TransferDto transferDto) {
        log.info("Перевод с карты " + transferDto.getCardFromNumber() + " на карту " + transferDto.getCardToNumber() + " сумма перевода: " + transferDto.getAmount().getValue());
           transferService.transfer(transferDto);
           return ResponseEntity.ok().build();
    }
}
