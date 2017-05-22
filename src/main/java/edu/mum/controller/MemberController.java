package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Member;
import edu.mum.service.MemberService;

@Controller
@RequestMapping({"/members"})
public class MemberController {
	
	@Autowired
	private MemberService  memberService;

	@RequestMapping
	public String listMembers(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "members";
	}
	
  	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		Member member = memberService.findOne(id);
		model.addAttribute("member", member);

 		return "member";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newMember") Member newMember) {
	   return "addMember";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newMember") @Valid Member memberToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addMember";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
			memberService.saveFull(memberToBeAdded);

	   	return "redirect:/members";
 
	}
	
 
}
