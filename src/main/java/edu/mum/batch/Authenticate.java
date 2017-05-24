package edu.mum.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Authenticate  implements Tasklet{
	
	@Autowired
	  private ApplicationContext applicationContext;
	
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
//		 AuthenticationManager authenticationManager = (AuthenticationManager) applicationContext.getBean("authenticationManager");
//	 
//    Authentication request = new UsernamePasswordAuthenticationToken("Batch", "Pete");
//    Authentication result = authenticationManager.authenticate(request);
//    SecurityContextHolder.getContext().setAuthentication(result);
		
		System.out.println("========> BATCH AUTHENTICATION =========>");
    return RepeatStatus.FINISHED;
	}

  
}
