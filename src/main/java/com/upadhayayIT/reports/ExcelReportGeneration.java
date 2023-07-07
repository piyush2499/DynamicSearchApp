package com.upadhayayIT.reports;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.upadhayayIT.bindings.response.PlanResponse;
public class ExcelReportGeneration {

	public void export(List<PlanResponse> plans,HttpServletResponse response) throws Exception{
		
		XSSFWorkbook workbook= new XSSFWorkbook();//WorkBook create
		
		XSSFSheet sheet=workbook.createSheet("plans");//crate sheet here
	    
		XSSFRow headerRow=sheet.createRow(0);//crate Header Row
	
		//create 5 cell (Column) to set Data Here
		
		XSSFCell headerCell0=headerRow.createCell(0);//crate cell(Column) here
		headerCell0.setCellValue("Plan ID");
		
		headerRow.createCell(1).setCellValue("Holder Name");
	
		
		headerRow.createCell(2).setCellValue("Holder SSN");
		
		
		headerRow.createCell(3).setCellValue("Plan Name");
		
		
		headerRow.createCell(4).setCellValue("Plan Status");
	
		
	    
		for(int i=0;i<plans.size();i++) {
			PlanResponse plan=plans.get(i);
		
			XSSFRow dataRow=sheet.createRow(i+1);//Row Increase Dynamically here
		
		//With That Row 5 Cell(Column) Increase Dynamically
		XSSFCell cell0=dataRow.createCell(0);
		cell0.setCellValue(plan.getPlanId());
		
		dataRow.createCell(1).setCellValue(plan.getPlanHolderName());
		
		dataRow.createCell(2).setCellValue(plan.getPlanHolderSsn());

		dataRow.createCell(3).setCellValue(plan.getPlanName());
	
		dataRow.createCell(4).setCellValue(plan.getPlanStatus());
		}
		
				ServletOutputStream outputStream=response.getOutputStream();
				
				workbook.write(outputStream);
		        workbook.close();
		        outputStream.close();
		
	}
}
