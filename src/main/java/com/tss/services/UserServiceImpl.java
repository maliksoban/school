package com.tss.services;

import com.tss.domain.Role;
import com.tss.domain.User;
import com.tss.dto.UserDTO;
import com.tss.mapper.UserDomainToDTOMapper;
import com.tss.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Defining User Service
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    /*
   Autowiring user repository
    */
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

    Logger logger = LogManager.getRootLogger();

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getDeletedUser(Integer id) {
        return userRepository.findByStatus(id);
    }

    @Override
    public User findUserExist(UserDTO userDTO) {
        return userRepository.findUserExist(userDTO.getUserName(),userDTO.getEmail());

    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    /**
     * This Method is saving users in {@link User}
     * @param userDTO
     */

    @Override
    public void create(UserDTO userDTO) {

        logger.trace("Entering into create user ");
        Integer roleId = userDTO.getRoleId();
        Role role = roleService.getRoleById(roleId);
        User user = UserDomainToDTOMapper.convertDomainUser(userDTO,role);
        user.setUserPassword(passwordEncoder.encode(userDTO.getUserPass()));
        logger.info("password encoded ");
        user.setEnabled(true);
        logger.trace("Exiting from create user ");
        userRepository.save(user);
        logger.info("new user has been created: {}", user.getEmail());
    }


}
