package com.nagarro.restbackApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restbackApi.Models.Batch;

public interface BatchRepository extends JpaRepository<Batch, String> {

}
