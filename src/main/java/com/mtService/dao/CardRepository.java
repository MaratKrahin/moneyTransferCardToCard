package com.mtService.dao;

import com.mtService.dao.model.Card;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    @Query("select * from card where user_id = :userId")
    List<Card> findAllByUserId(@Param("userId") Long userId);

    @Query("select * from card where number = :number")
    Optional<Card> findCardByNumber(@Param("number") String number);

}
