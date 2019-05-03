package com.nagarro.restbackApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restbackApi.Models.Level;

public interface LevelRepository extends JpaRepository<Level, String> {

}
