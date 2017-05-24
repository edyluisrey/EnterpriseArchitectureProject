package edu.mum.batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.batch.email.EmailService;
import edu.mum.domain.Report;

/*
 * Declared in user-job.xml
 */
public class ReportWriter implements Tasklet{
	
	private static final String FILE_NAME = "src/main/resources/reports/HotelDailyReport.xlsx";
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

		System.out.println("============ReportWriter=============");
		
	       XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
	        Object[][] datatypes = {
	                {"Datatype", "Type", "Size(in bytes)"},
	                {"int", "Primitive", 2},
	                {"float", "Primitive", 4},
	                {"double", "Primitive", 8},
	                {"char", "Primitive", 1},
	                {"String", "Non-Primitive", "No fixed size"}
	        };

	        int rowNum = 0;
	        System.out.println("Creating excel");

	        for (Object[] datatype : datatypes) {
	            Row row = sheet.createRow(rowNum++);
	            int colNum = 0;
	            for (Object field : datatype) {
	                Cell cell = row.createCell(colNum++);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }
	        }
	        
	        FileOutputStream outputStream = null;
	        try {
	            outputStream = new FileOutputStream(FILE_NAME);
	            workbook.write(outputStream);
	            workbook.close();
	            System.out.println("report generated successfully.....");
	            outputStream.close();
	            
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	        	e.printStackTrace();
	        }finally{
	        	
	        		try{
	        			if(outputStream!=null){
	        				outputStream.close();
	        			}
	        		    Report report = new Report();
	        		    report.setId(12);
	        		    report.setDate(new Date());
	        		    
	        		    String documentName = "HotelDailyReport.xlsx";
	        		    File file = new File(FILE_NAME);
	        		    System.out.println("file Exist==>"+file.exists());
        		    	emailService.sendOrderReceivedMail("Kimchi", "electromemphis1@gmail.com",report,documentName,new Locale("en"),file);
	        			
	        		}catch (Exception e) {
						e.printStackTrace();
					}
	        	
	        }

	        System.out.println("Done");

		
		return RepeatStatus.FINISHED;
	}




}

