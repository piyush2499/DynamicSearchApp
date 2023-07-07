package com.upadhayayIT.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upadhayayIT.entity.InsurancePlanEntity;

public interface IInsurancePlanRepository extends JpaRepository<InsurancePlanEntity, Serializable> {
    
	@Query(value="select distinct planName from InsurancePlanEntity")
	public List<String> getPlanNames();//Unique plan name from db
    
	@Query(value="select distinct planStatus from InsurancePlanEntity ")
    public List<String> getPlanStatus();//Unique plan status from db
}
