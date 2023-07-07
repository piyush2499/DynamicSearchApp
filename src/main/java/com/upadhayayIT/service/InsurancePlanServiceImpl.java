package com.upadhayayIT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.upadhayayIT.bindings.request.SearchRequest;
import com.upadhayayIT.bindings.response.PlanResponse;
import com.upadhayayIT.entity.InsurancePlanEntity;
import com.upadhayayIT.repository.IInsurancePlanRepository;

@Service
public class InsurancePlanServiceImpl implements IInsurancePlanService {
     
	@Autowired
	private IInsurancePlanRepository repo;
	
	@Override
	public List<PlanResponse> searchPlan(SearchRequest request) {
		InsurancePlanEntity entity= new InsurancePlanEntity();//obj create here
		
		if( request !=null && request.getPlanName()!=null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}
		if( request !=null && request.getPlaneStatus()!=null && !request.getPlaneStatus().equals("")) {
			entity.setPlanStatus(request.getPlaneStatus());
		}
		//Example from Data Jpa Repo this is Generate  Dynamic Query
		Example<InsurancePlanEntity> of=Example.of(entity);
		List<InsurancePlanEntity> findAll=repo.findAll(of);
		
		List<PlanResponse> plans=new ArrayList();
		
		for(InsurancePlanEntity plan:findAll) {
			PlanResponse presp=new PlanResponse();
			BeanUtils.copyProperties(plan, presp);//copy data from entity class to Response Bindings class
			plans.add(presp);
		}
		return plans;
	}

	@Override
	public List<String> getPlanNames() {
		
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}
	
}
