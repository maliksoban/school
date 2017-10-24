package com.tss.mapper;

import com.tss.domain.Role;
import com.tss.domain.StatusEnum;
import com.tss.dto.RoleDTO;

public class RoleDomainToDTOMapper {

    private RoleDomainToDTOMapper() {
    }

    public static Role convertToRoleDomain(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getRoleId());
        role.setRoleName(roleDTO.getRoleName());
        return role;
    }

}
