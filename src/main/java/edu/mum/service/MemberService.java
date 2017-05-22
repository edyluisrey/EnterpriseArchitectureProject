package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.Member;
 
public interface MemberService {

	public void save(Member member);
    	public void saveFull( Member member);  		

	public List<Member> findAll();
 	public Member findOne(Long id);
 		
}
