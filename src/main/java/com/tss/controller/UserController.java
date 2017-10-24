package com.tss.controller;

import com.tss.common.Common;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MalikSoban on 31/08/2017.
 */
@Controller
@Log4j2
public class UserController {

    /**
     * This method is redirecting user to guest User page
     * @param model
     * @return  "guestUser.jsp"
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        Common common = new Common();
        model.addAttribute("user", common.getPrincipal());
        return "/guestUser";
    }
}
