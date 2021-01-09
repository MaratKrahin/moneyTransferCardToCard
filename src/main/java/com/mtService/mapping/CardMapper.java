package com.mtService.mapping;

import com.mtService.dto.CardDto;
import com.mtService.dao.model.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

   CardDto toDto(Card card);

   List<CardDto> toDto(List<Card> cards);
}
