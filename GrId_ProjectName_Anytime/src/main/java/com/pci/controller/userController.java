package com.pci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pci.entity.MtUser;
import com.pci.repository.UserRepository;
import com.pci.security.UserAccount;


@Controller
@SessionAttributes("dummyModel")		
public class userController {
/*	
	@Autowired
	UserRepository userRepo;
	
	public MtUser logiUser(Authentication authentication) {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		MtUser loginUser = new MtUser();
	    if(authentication.getPrincipal() instanceof UserAccount){
	    	UserAccount user = UserAccount.class.cast(authentication.getPrincipal());
	    	loginUser = userRepo.findByUserCode(user.getUserCode());
	    }
	    return loginUser;
	}
*/
	@RequestMapping(value = "/dummyMember", method = RequestMethod.POST)
	public ModelAndView userDummy(ModelAndView mav,Authentication authentication) {
//		MtUser loginUser = logiUser(authentication);
//		mav.addObject("loginUser", loginUser);		
		mav.setViewName("200user/210userFunction");	
		return mav;
	}
}
