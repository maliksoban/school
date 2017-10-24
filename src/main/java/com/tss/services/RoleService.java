package com.tss.services;

import com.tss.domain.Role;

import java.util.List;

/**
 * Created by MalikSoban on 31/08/2017.
 */
public interface RoleService {

    void saveOrUpdate(Role role);

    Role getRoleById(int id);

    List<Role> viewRoles();

}
