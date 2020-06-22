package com.pci.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pci.entity.MtItem;
import com.pci.entity.MtUser;
import com.pci.repository.ItemRepository;
import com.pci.repository.UserRepository;
import com.pci.security.UserAccount;

/**
 * ログインコントローラ
 */
@SessionAttributes("loginUser")
@Controller
public class LoginController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	ItemRepository itemRepo;
	
	@ModelAttribute(value = "loginUser")
	public MtUser setupLoginUser() {
		return new MtUser();
	}
	
	/**
	 * /loginで起動されるメソッド
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) {
		mav.addObject("iserror", false);
		mav.setViewName("000login");
	    return mav;
	}

	/**
	 * /indexで起動されるメソッド
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, Authentication authentication) {
		mav.addObject("iserror", false);
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		authentication = SecurityContextHolder.getContext().getAuthentication();
	    if(authentication.getPrincipal() instanceof UserAccount){
	    	UserAccount user = UserAccount.class.cast(authentication.getPrincipal());
	    	MtUser loginUser = userRepo.findByUserCode(user.getUserCode());
//	    	mav.addObject("loginUser", loginUser);
			for (GrantedAuthority grantedAuthority : authorities){
                    if (grantedAuthority.getAuthority().equals("ROLE_MGR")) {
                    	//"100mgr/100mgrTop"表示用の処理を記載
                    	List<MtItem> itemList = itemRepo.findAll();
                    	mav.addObject("itemList", itemList);
			        	mav.setViewName("100mgr/100mgrTop");
			            break;
			        }else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                    	//"200user/200userTop"表示用の処理を記載
			        	mav.setViewName("200user/200userTop");
			            break;
			        }
		    }
	    }
	    return mav;
	}

	/**
	 * /login-errorで起動されるメソッド
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public ModelAndView loginError(ModelAndView mav) {
		mav.addObject("iserror",true);
		mav.setViewName("000login");
		return mav;
	}
}