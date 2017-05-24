package edu.mum.main.batch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.batch.ProductBatch;

@Component 
public class Main {
 
	@Autowired
	ProductBatch productBatch;
	
  public static void main(String[] args) throws Throwable {

    ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml",
    		"context/batch-config.xml","context/user-job.xml","context/mail-config.xml");
    	context.getBean(Main.class).mainInternal(context);
  	}
  
    private void mainInternal(ApplicationContext applicationContext) throws Exception {
 
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println("Starting System " + dateFormat.format(date));  
   
	// This "manual mode" ...ProductBatch will be SCHEDULED if @Scheduled is on ProductBatch Class
// productBatch.startjob();
	
  }
 }