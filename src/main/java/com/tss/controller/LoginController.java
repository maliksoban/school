package com.tss.controller;

import com.tss.common.Common;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
public class LoginController {

    /**
     * This method is redirecting user to home
     * @param model
     * @return "home.jsp"
     */
	@RequestMapping(value = {"/","/home"})
	public String homePage(ModelMap model) {
        Common common = new Common();
        model.addAttribute("user", common.getPrincipal());
		return "home";
	}

    /**
     * This method is used to redirect user to login page
     * @return "home.jsp"
     */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "home";
	}

    /**
     * This method is used for UnAuthenticated user
     * @param model
     * @return "accessDenied.jsp"
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        Common common = new Common();
        model.addAttribute("user", common.getPrincipal());
        return "accessDenied";
    }

    /**
     * This method used to signOut/logout the login user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}