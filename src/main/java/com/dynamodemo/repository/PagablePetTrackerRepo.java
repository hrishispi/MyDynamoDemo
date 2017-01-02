package com.dynamodemo.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dynamodemo.model.FindMyPetId;
import com.dynamodemo.model.PetTracker;

@Repository
public interface PagablePetTrackerRepo extends PagingAndSortingRepository<PetTracker, FindMyPetId> {

  @EnableScan 
  @EnableScanCount
  public List<PetTracker> findAll();
  
  @EnableScan 
  @EnableScanCount
  public List<PetTracker> findByPetIdOrderByDateReportedDesc(@Param("petId") String petId);
}