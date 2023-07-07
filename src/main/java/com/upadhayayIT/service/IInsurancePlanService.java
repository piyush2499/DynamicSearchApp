package com.upadhayayIT.service;

import java.util.List;

import com.upadhayayIT.bindings.request.SearchRequest;
import com.upadhayayIT.bindings.response.PlanResponse;

public interface IInsurancePlanService {

	public List<PlanResponse>searchPlan(SearchRequest request);
	public List<String> getPlanNames();//Unique plan name from db
	 public List<String> getPlanStatus();
}
