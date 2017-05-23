package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Audit;
import edu.mum.service.AuditService;

@RestController
@RequestMapping({"/api/audits"})
public class AuditController {
	
	@Autowired
	private AuditService  auditService;

	@RequestMapping
	public @ResponseBody List<Audit>  findAll( ) {
		return  auditService.findAll();
 
	}
 
}
