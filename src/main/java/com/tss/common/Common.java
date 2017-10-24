package com.tss.common;

import com.tss.services.RoleService;
import com.tss.services.UserService;
import com.tss.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by MalikSoban on 31/08/2017.
 */
@Component
public class Common {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public RoleService roleService;

    @Autowired
    public UserService userService;


    /**
     * This method is used for get Current User Details
     * @return userName
     */
    public String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
