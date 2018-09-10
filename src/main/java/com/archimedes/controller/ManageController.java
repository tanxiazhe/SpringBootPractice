package com.archimedes.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.archimedes.domain.User;
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

@Api(value = "ManageController", description = "Login Api")
@Controller
public class ManageController {

    @Autowired
    UserService userService;

    @Autowired
    ConferenceService conferenceService;

    @ApiOperation(value = "Home", notes = "Home.")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map<String, Object> map,HttpSession session) {
        return login(map,session);
    }

    @ApiOperation(value = "Index", notes = "Index.")
    @RequestMapping(value = "/index")
    public String index(HttpSession session,Map<String, Object> map) {
       return home(map,session);
    }

    @ApiOperation(value = "Login", notes = "Login.")
    @RequestMapping("/login")
    public String login(Map<String, Object> map, HttpSession session) {
        String emailSession = (String) session.getAttribute("email");

        if (!StringUtils.isEmpty(emailSession)) {
            map.put("message", "hello,");
            map.put("email", session.getAttribute("email"));
            map.put("port", session.getAttribute("port"));

            List<Conference> conferenceList = conferenceService.getConferences();
            map.put("conferenceList", conferenceList);

            return "ftl/center";
        }
        return "ftl/login";
    }

    @ApiOperation(value = "do Login", notes = "Do login.")
    @RequestMapping("/doLogin")
    public String doLogin(Map<String, Object> map, HttpServletRequest request, HttpSession session, String email,
            String password, RedirectAttributes model) {

        try {
            userService.getUserByEmailAndPassword(email, password);
            session.setAttribute("email", email);
            session.setAttribute("port", request.getLocalPort());
            center(map, request, session, email);
            return "redirect:/center";
        } catch (Exception e) {
            model.addFlashAttribute("message", e.getMessage());
            return "redirect:/errorHandler";
        }
    }

    @ApiOperation(value = "Center", notes = "Do login.")
    @RequestMapping("/center")
    public String center(Map<String, Object> map, HttpServletRequest request, HttpSession session, String email) {

        String usernameSession = (String) session.getAttribute("email");

        if (StringUtils.isEmpty(usernameSession)) {
            return "ftl/login";
        }

        map.put("message", "hello,");
        map.put("email", email);
        map.put("port", request.getLocalPort());

        List<Conference> conferenceList = conferenceService.getConferences();
        map.put("conferenceList", conferenceList);

        return "ftl/center";
    }

    @ApiOperation(value = "Logout", notes = "Log out.")
    @RequestMapping("/logout")
    public String logout(Map<String, Object> map, HttpServletRequest request, HttpSession session, SessionStatus sessionStatus) {
        session.removeAttribute("email");
        session.removeAttribute("port");
        sessionStatus.setComplete();
        map.put("port", request.getLocalPort());
        return "ftl/index";
    }

    @ApiOperation(value = "Error", notes = "Error.")
    @RequestMapping("/errorHandler")
    public ModelAndView errorHandler(HttpServletRequest request, Map<String, Object> map) {
        return new ModelAndView("ftl/error").addObject("port", request.getLocalPort());
    }

    @ApiOperation(value = "do register", notes = "do register.")
    @RequestMapping("/doRegister")
    public String doRegister(HttpSession session, HttpServletRequest request, Map<String, Object> map, String userName,
            String email, String password, String confirmPassword, RedirectAttributes model) {

        try {
            if (!password.equals(confirmPassword)) {
                model.addFlashAttribute("message", "password is not equals to confirm password");
                return "redirect:/errorHandler";
            }
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            userService.addUser(user);
            session.setAttribute("email", email);
            session.setAttribute("port", request.getLocalPort());
            center(map, request, session, userName);
            return "redirect:/center";
        } catch (Exception e) {
            model.addFlashAttribute("message", e.getMessage());
            return "redirect:/errorHandler";
        }
    }

    @ApiOperation(value = "About", notes = "About.")
    @RequestMapping("/about")
    public String about(Map<String, Object> map, HttpSession session) {
        String emailSession = (String) session.getAttribute("email");

        if (!StringUtils.isEmpty(emailSession)) {
            map.put("message", "hello,");
            map.put("email", session.getAttribute("email"));
            map.put("port", session.getAttribute("port"));

            User user = userService.getUserByEmail(emailSession);
            map.put("user", user);

            return "ftl/about";
        }
        return "ftl/login";
    }

    @ApiOperation(value = "do change user", notes = "Do Change User.")
    @RequestMapping("/doChangeUser")
    public String doChangeUser(Map<String, Object> map, HttpServletRequest request, HttpSession session,
            String userName, String firstName, String lastName, RedirectAttributes model) {

        try {
            String emailSession = (String) session.getAttribute("email");

            if (!StringUtils.isEmpty(emailSession)) {
                session.setAttribute("email", emailSession);
                session.setAttribute("port", request.getLocalPort());
                User updatedUser = userService.getUserByEmail(emailSession);
                updatedUser.setUserName(userName);
                updatedUser.setFirstName(firstName);
                updatedUser.setLastName(lastName);
                userService.updateUser(updatedUser.getId(), updatedUser);
                return "redirect:/about";
            }
            return "ftl/login";
        } catch (Exception e) {
            model.addFlashAttribute("message", e.getMessage());
            return "redirect:/errorHandler";
        }
    }

    @ApiOperation(value = "recover", notes = "Recover.")
    @RequestMapping("/recover")
    public String recover(Map<String, Object> map, HttpServletRequest request, HttpSession session, String email,
            RedirectAttributes model) {
        try {
            session.setAttribute("email", email);
            session.setAttribute("port", request.getLocalPort());
            User updatedUser = userService.getUserByEmail(email);
            return "ftl/reset";
        } catch (Exception e) {
            model.addFlashAttribute("message", e.getMessage());
            return "redirect:/errorHandler";
        }

    }

    @ApiOperation(value = "do recover", notes = "Do Recover.")
    @RequestMapping("/doRecover")
    public String doRecover(HttpSession session, HttpServletRequest request, Map<String, Object> map, String userName,
            String email, String password, String confirmPassword, RedirectAttributes model) {

        try {
            String emailSession = (String) session.getAttribute("email");
            if (StringUtils.isEmpty(emailSession)) {
                model.addFlashAttribute("message", "email not exists.");
                return "redirect:/errorHandler";
            }
            if (!password.equals(confirmPassword)) {
                model.addFlashAttribute("message", "password is not equals to confirm password");
                return "redirect:/errorHandler";
            }
            session.setAttribute("email", emailSession);
            session.setAttribute("port", request.getLocalPort());
            User updatedUser = userService.getUserByEmail(emailSession);
            updatedUser.setPassword(password);
            userService.updateUser(updatedUser.getId(), updatedUser);
            return "redirect:/about";
        } catch (Exception e) {
            model.addFlashAttribute("message", e.getMessage());
            return "redirect:/errorHandler";
        }
    }
}
