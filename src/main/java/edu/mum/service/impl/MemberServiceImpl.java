package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( Member member) {  		
		memberDao.save(member);
	}
	
 	
    @Override
   	public void saveFull( Member member) {  		
  		credentialsService.save(member.getUserCredentials());
  		memberDao.save(member);
	}
  	

	public List<Member> findAll() {
		return (List<Member>)memberDao.findAll();
	}

 	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}
	
 
}
