package com.tss.services;

import com.tss.domain.Role;
import com.tss.repositories.RoleRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    Logger logger = LogManager.getRootLogger();

    /**
     * This Method is saving roles in {@link Role}
     * @param role
     */
    @Override
    public void saveOrUpdate(Role role) {
        logger.trace("Entering into saveOrUpdate Method");
        roleRepository.save(role);
    }

    /**
     * This Method is returning Role by id from {@link RoleRepository}
     * @param id
     * @return returning roles on the basis of roleId
     */
    @Override
    public Role getRoleById(int id) {
        logger.trace("Entering into getRoleById");
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> viewRoles() {
        return roleRepository.findAll();
    }

}
