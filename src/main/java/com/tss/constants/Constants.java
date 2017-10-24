package com.tss.constants;

import com.tss.configuration.security.SecurityConfiguration;
import com.tss.controller.AdminController;

/**
 * Created by MalikSoban on 31/08/2017.
 */
public class Constants {

    private Constants(){
        //private no argument constructor
    }

    /**
     spring security configuration constants used in {@link SecurityConfiguration}
     */
    public static final String GET_USER_QUERY = "select username,password,enabled from user where username=?";
    public static final String GET_AUTHORITY_QUERY = "select u.username,r.role from user u" +
            " inner join user_roles ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id)" +
            " where u.username=?";
    public static final String USER_ACCESS= "hasRole('ROLE_USER')";
    public static final String ADMIN_ACCESS= "hasRole('ROLE_ADMIN')";
    public static final String ADMIN_DBA_ACCESS= "hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')";

    /**
     * Constants used in {@link AdminController}
     */
    public static final String ADMIN = "admin";
    public static final String FAILED = "Failed";
    public static final String SUCCESS = "Successfully";
    public static final String COMMAND = "command";
    public static final String ERRORPAGE = "errorpage2";

    public static final  String SUCCESS_MESSAGE = "Successfully_data_sent";
    public static final  String FAILED_MESSAGE = "Failed_to_get_data";
    public static final  String CLASS_MESSAGE = "Classes_found";

}
