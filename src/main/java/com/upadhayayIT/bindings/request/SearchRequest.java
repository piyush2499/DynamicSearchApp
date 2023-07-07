 package com.upadhayayIT.bindings.request;
//Search Request come from UI Application with use of 2 data name and status only
public class SearchRequest {
    private String planName;
    private String planeStatus;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlaneStatus() {
		return planeStatus;
	}
	public void setPlaneStatus(String planeStatus) {
		this.planeStatus = planeStatus;
	}
	@Override
	public String toString() {
		return "SearchRequest [planName=" + planName + ", planeStatus=" + planeStatus + "]";
	}
	public SearchRequest(String planName, String planeStatus) {
		super();
		this.planName = planName;
		this.planeStatus = planeStatus;
	}
    
}
