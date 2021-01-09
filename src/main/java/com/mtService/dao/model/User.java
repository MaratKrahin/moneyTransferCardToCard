package com.mtService.dao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Data
public class User {
    @Id
    private Long id;
    private String name;
    private Set<Card> cards;
}
