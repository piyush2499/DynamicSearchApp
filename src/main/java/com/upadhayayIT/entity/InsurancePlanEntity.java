package com.upadhayayIT.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="INSURANCE_PLANS")
public class InsurancePlanEntity {
    @Id
    @GeneratedValue
    @Column(name="planId")
	private Integer planId;
    @Column(name="planName")
	private String planName;
    @Column(name="planHolderName")
	private String planHolderName;
    @Column(name="planHolderSsn")
	private Long planHolderSsn;
    @Column(name="planStatus")
	private String planStatus;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanHolderName() {
		return planHolderName;
	}
	public void setPlanHolderName(String planHolderName) {
		this.planHolderName = planHolderName;
	}
	public Long getPlanHolderSsn() {
		return planHolderSsn;
	}
	public void setPlanHolderSsn(Long planHolderSsn) {
		this.planHolderSsn = planHolderSsn;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public InsurancePlanEntity(Integer planId, String planName, String planHolderName, Long planHolderSsn,
			String planStatus) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planHolderName = planHolderName;
		this.planHolderSsn = planHolderSsn;
		this.planStatus = planStatus;
	}
	public InsurancePlanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsurancePlanEntity [planId=" + planId + ", planName=" + planName + ", planHolderName=" + planHolderName
				+ ", planHolderSsn=" + planHolderSsn + ", planStatus=" + planStatus + "]";
	}
	
	
}
