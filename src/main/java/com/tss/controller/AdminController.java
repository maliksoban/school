package com.tss.controller;

import com.tss.constants.Constants;
import com.tss.domain.Role;
import com.tss.domain.StatusEnum;
import com.tss.domain.User;
import com.tss.dto.RoleDTO;
import com.tss.dto.UserDTO;
import com.tss.exception.UserAlreadyExistException;
import com.tss.mapper.ResponseObjectMapper;
import com.tss.mapper.RoleDomainToDTOMapper;
import com.tss.common.Common;
import com.tss.common.ResponseObject;
import com.tss.mapper.UserDomainToDTOMapper;
import com.tss.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MalikSoban on 31/08/2017.
 */
@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    Common common;

    @Autowired
    UserService userService;

    HttpHeaders headers = new HttpHeaders();
    Logger logger = LogManager.getRootLogger();

    /*========================== These Services are used for Redirecting to different pages =========================*/

    /**
     * This method is redirecting user to admin.jsp
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", common.getPrincipal());
        return Constants.ADMIN;
    }

    /*================================= CRUD operations on User and Roles  ==========================================*/

    /**
     * This method is used for Saving a new User
     *
     * @param userDTO getting data from {@link UserDTO}
     * @return setting data by user object into {@link User}
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity saveOrUpdateUser(@RequestBody UserDTO userDTO) {
        logger.trace("Entering into SaveUser Method");
        User user = userService.findUserExist(userDTO);
        if (user == null) {
            logger.trace("Entering into Create User controller service");
            userService.create(userDTO);
            return new ResponseEntity(userDTO.getFullName(), headers, HttpStatus.CREATED);
        } else {
            UserAlreadyExistException userAlreadyExistException = new UserAlreadyExistException
                    ("User Already exists");
            logger.error(userAlreadyExistException);
            throw userAlreadyExistException;
        }
    }


    /**
     * This method is Getting data of product
     * @param uId get data of that id
     * @return
     */
    @RequestMapping(value = "/editUser/{uId}",method = RequestMethod.PUT)
    public ResponseEntity editUser(@PathVariable("uId") Integer uId) {
        logger.trace("Entering into editUser Method");
        try {
            logger.info("Get User By ",uId);
            User user = common.userService.getUserById(uId);
            logger.trace("exiting from editUser Try method");
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (DataAccessException ee) {
            logger.error("editUser method throws exception "+ ee);
            return new ResponseEntity(Constants.FAILED, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method will Delete user by his id
     * @param userId Get user by userId
     * @return
     */
    @RequestMapping(value = "/userDelete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userId") int userId)
    {
        try {
            User user = common.userService.getUserById(userId);
            user.setStatus(StatusEnum.DELETED.getId());
            common.userService.saveOrUpdate(user);
            return new ResponseEntity(Constants.SUCCESS,HttpStatus.OK);
        } catch (DataAccessException ee) {
            logger.error("catch method of deleteUser is called" + ee);
            return new ResponseEntity(Constants.FAILED,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * this method will get all the user having status DELETED
     * @return Status DELETED user from {@link User}
     */
    @RequestMapping(value = "/DeletedUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject viewDeletedUser() {

        try {
            List<User> userList = common.userService.getDeletedUser(StatusEnum.DELETED.getId());
            List<UserDTO> userDTOList = UserDomainToDTOMapper.convertDomaintoDTOList(userList);
            if (userDTOList.isEmpty()) {
                logger.debug("list empty" + userDTOList);
                return ResponseObjectMapper.convertResponseObjectMapperList(Constants.FAILED, "no record found", userDTOList);
            }
            return ResponseObjectMapper.convertResponseObjectMapperList(Constants.SUCCESS, Constants.SUCCESS_MESSAGE, userDTOList);
        } catch (DataAccessException ee) {
            logger.error("catch method of viewDeletedUser is called" + ee);
            return ResponseObjectMapper.convertResponseObjectMapperList(Constants.FAILED, Constants.FAILED_MESSAGE, null);
        }
    }

    /**
     * This method is Saving a new Role
     *
     * @param roleDTO getting data from {@link RoleDTO}
     * @return setting data by user object into {@link Role}
     */
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public ResponseEntity saveOrUpdateRole(@RequestBody RoleDTO roleDTO) {
        logger.trace("Entering into saveRole Method");
        try {
            logger.info("Storing Role into Role");
            Role role = RoleDomainToDTOMapper.convertToRoleDomain(roleDTO);
            common.roleService.saveOrUpdate(role);
            logger.trace("Exiting from saveRole Method");
            return new ResponseEntity(Constants.SUCCESS, HttpStatus.OK);
        } catch (DataAccessException ee) {
            logger.error("saveRole throws exception ",ee);
            return new ResponseEntity(Constants.FAILED, HttpStatus.NOT_FOUND);
        }
    }


    /**
     *  Getting the role of requested role for editing
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/editRole/{roleId}",method = RequestMethod.PUT)
    public ResponseEntity editRole(@PathVariable("roleId") int roleId) {
        logger.trace("Entering into editRole Method");
        try {
            logger.info("Get Role By ",roleId);
            Role role = common.roleService.getRoleById(roleId);
            logger.trace("exiting from Role Try method");
            return new ResponseEntity(role, HttpStatus.OK);
        } catch (DataAccessException ee) {
            logger.error("editRole method throws exception "+ ee);
            return new ResponseEntity(Constants.FAILED, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This method get all the Roles from the DB
     *
     * @return
     */
    @RequestMapping(value = "/viewRoles", method = RequestMethod.GET)
    public ResponseEntity viewRoles() {

        try {
            logger.trace("Entering into getCountry Method");
            List<Role> roleList = common.roleService.viewRoles();
            logger.trace("Exiting from getCountry Method");
            if (roleList.isEmpty()) {
                logger.info("No Record Found");
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            } else
                return new ResponseEntity(roleList, HttpStatus.OK);
        } catch (DataAccessException ee) {
            logger.error("getCountry throws ",ee);
            return new ResponseEntity(Constants.FAILED, HttpStatus.NOT_FOUND);
        }
    }
}
