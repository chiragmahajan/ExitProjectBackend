package com.nagarro.restbackApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.restbackApi.Models.ApplicantDetails;

@Repository
public interface ApplicantListRepository extends JpaRepository<ApplicantDetails, Integer> {

}
