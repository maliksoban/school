package com.tss.configuration.security;

import com.tss.constants.Constants;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Component
@Log4j2
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    Logger logger = LogManager.getRootLogger();

    protected static final String[] PERMIT_ALL_RESOURCE_LIST = new String[] { "/Access_Denied","/login/**","/home/**", "/" };
    protected static final String[] USER_RESOURCE_LIST = new String[]{"/user/**"};
    protected static final String[] ADMIN_RESOURCE_LIST = new String[] {"/admin/**", "/delete-user-*"};
    protected static final String[] ADMIN_DBA_RESOURCE_LIST = new String[]{"/edit-user-*"};

    /**
     * this method used for JDBC authorization and authentication
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        logger.trace("Entering into jdbcAuthentication method");
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(getUserQuery())
                .authoritiesByUsernameQuery(getAuthoritiesQuery());
        logger.trace("Exiting from jdbcAuthentication method");
    }

    /**
     * This method is used for password encoding
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * Thsi method is granting the Authentication/previlages for a user
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers(PERMIT_ALL_RESOURCE_LIST).permitAll()
                .antMatchers(USER_RESOURCE_LIST).access(Constants.USER_ACCESS)
                .antMatchers(ADMIN_RESOURCE_LIST).access(Constants.ADMIN_ACCESS)
                .antMatchers(ADMIN_DBA_RESOURCE_LIST).access(Constants.ADMIN_DBA_ACCESS)
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/home")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/Access_Denied")
                .and()
                .csrf().disable();
    }

    /**
     * This method is getting user authentication through Query
     * @return string query
     */
    private String getUserQuery() {
        return Constants.GET_USER_QUERY;
    }

    /**
     * This method is getting user authorization through Query
     * @return string query
     */
    private String getAuthoritiesQuery() {
        return Constants.GET_AUTHORITY_QUERY;
    }
}
