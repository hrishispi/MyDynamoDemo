package com.dynamodemo.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dynamodemo.model.PetTracker;
import com.dynamodemo.model.Restaurant;

@Repository
public interface PagablePetTrackerRepo extends PagingAndSortingRepository<PetTracker, String> {

  @EnableScan 
  @EnableScanCount
  public List<PetTracker> findAll();
  
  @EnableScan 
  @EnableScanCount
  public List<PetTracker> findByPetId(@Param("petId") String petId);
}