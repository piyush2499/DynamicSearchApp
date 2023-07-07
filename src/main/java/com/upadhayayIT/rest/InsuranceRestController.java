package com.upadhayayIT.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upadhayayIT.bindings.request.SearchRequest;
import com.upadhayayIT.bindings.response.PlanResponse;
import com.upadhayayIT.reports.ExcelReportGeneration;
import com.upadhayayIT.reports.PdfReportGeneration;
import com.upadhayayIT.service.IInsurancePlanService;

@RestController
public class InsuranceRestController {
  
	@Autowired
	private IInsurancePlanService service;
	
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response)throws Exception {
	

        response.setContentType("application/pdf");
       
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans.pdf";
		response.setHeader(headerKey, headerValue);
        
		List<PlanResponse>plans=service.searchPlan(null);
		PdfReportGeneration pdfReport = new PdfReportGeneration();
	        pdfReport.exportPdf(plans,response);
		
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response)throws Exception {
	

        response.setContentType("application/octet-stream");
       
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans.xlsx";
		response.setHeader(headerKey, headerValue);
        
		List<PlanResponse>plans=service.searchPlan(null);
		ExcelReportGeneration excelReport=new ExcelReportGeneration();
		excelReport.export(plans, response);
	}
	
	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> searchPlans( @RequestBody SearchRequest request){
	
		List<PlanResponse>searchPlans =	service.searchPlan(request);
		return new ResponseEntity<List<PlanResponse>>(searchPlans,HttpStatus.OK);
	}
    
	@GetMapping("/plannames")
    public ResponseEntity<List<String>> getPlanName(){
    	List<String> planNames= service.getPlanNames();
    	return new ResponseEntity<List<String>>(planNames,HttpStatus.OK);
   
    }
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getPlanStatus(){
		List<String> planStatus=service.getPlanStatus();
		return new ResponseEntity<List<String>>(planStatus,HttpStatus.OK);
	}

}
