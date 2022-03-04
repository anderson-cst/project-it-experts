package com.bootcamp.itexperts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.itexperts.models.CardModel;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Integer>{

}
