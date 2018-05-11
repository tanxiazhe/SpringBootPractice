package com.archimedes.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.archimedes.domain.Conference;
import com.archimedes.service.ConferenceService;
import com.archimedes.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "LoginController", description = "Login Api")
@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ConferenceService conferenceService;
	
	@ApiOperation(value = "Index", notes = "Index.")
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        return new ModelAndView("ftl/index").addObject("port",request.getLocalPort());
    }
	
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("ftl/index");
        
        modelAndView.addObject("port",request.getLocalPort());
        return modelAndView;
    }
	
	@ApiOperation(value = "Login", notes = "Login.")
	@RequestMapping("/login")
	public String login(Map<String,Object> map, HttpSession session) {
		String usernameSession = (String) session.getAttribute("userName");
		
		if(!StringUtils.isEmpty(usernameSession) ){
	        map.put("message", "hello,");
	        map.put("userName", session.getAttribute("userName"));
	        map.put("port", session.getAttribute("port"));
	        
	        List<Conference> conferenceList = conferenceService.getConferences();
	        map.put("conferenceList", conferenceList);
			
			return "ftl/center";
		}
		return "ftl/login";
	}
	
	@ApiOperation(value = "do Login", notes = "Do login.")
	@RequestMapping("/doLogin")
	public String  doLogin(Map<String,Object> map,HttpServletRequest request, HttpSession session, String userName, String password, RedirectAttributes model) {
		
		try{			
			userService.getUserByUserNameAndPassword(userName, password);
			session.setAttribute("userName", userName);
			session.setAttribute("port", request.getLocalPort());
	        center(map,request,session,userName,password);
	        return "redirect:/center";
		}catch(Exception e){
			model.addFlashAttribute("message",e.getMessage()); 
			return "redirect:/errorHandler";
		}
	}
	
	@ApiOperation(value = "Center", notes = "Do login.")
	@RequestMapping("/center")
	public String center(Map<String,Object> map,HttpServletRequest request, HttpSession session, String userName, String password) {
		
		String usernameSession = (String) session.getAttribute("userName");
		
		if(StringUtils.isEmpty(usernameSession) ){
			return "ftl/login";
		}
		
		map.put("message", "hello,");
        map.put("userName", userName);
        map.put("port",request.getLocalPort());
        
		List<Conference> conferenceList = conferenceService.getConferences();
        map.put("conferenceList", conferenceList);
		
		return "ftl/center";	
	}
	
	@ApiOperation(value = "Logout", notes = "Log out.")
	@RequestMapping("/logout")
	public String logout(Map<String,Object> map,HttpServletRequest request, HttpSession session, String userName, String password,SessionStatus sessionStatus) {
		session.removeAttribute("userName");
        session.removeAttribute("port");
        System.out.println("logout:"+session.getAttribute("userName"));
        sessionStatus.setComplete(); 
        map.put("port",request.getLocalPort());
		return "ftl/index";
	}
	
	
	@ApiOperation(value = "Error", notes = "Error.")
	@RequestMapping("/errorHandler")
    public ModelAndView errorHandler(HttpServletRequest request,Map<String,Object> map) {
        return new ModelAndView("ftl/error").addObject("port",request.getLocalPort());
    }

}
