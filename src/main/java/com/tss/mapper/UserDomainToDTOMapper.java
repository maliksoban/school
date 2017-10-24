package com.tss.mapper;

import com.tss.domain.StatusEnum;
import com.tss.dto.UserDTO;
import com.tss.domain.Role;
import com.tss.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MalikSoban on 21/09/2017.
 */

public class UserDomainToDTOMapper {


    private UserDomainToDTOMapper() {
        throw new IllegalStateException("User Mapper class");
    }

    public static User convertDomainUser(UserDTO userDTO, Role role) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setFullName(userDTO.getFullName());
        user.setCountry(userDTO.getCountry());
        user.setRoles(role);
        user.setAddress(userDTO.getAddress());
        user.setContactNo(userDTO.getPhoneNo());
        user.setStatus(StatusEnum.ACTIVE.getId());
        return user;
    }

    public static List<UserDTO> convertDomaintoDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            userDTO.setCountry(user.getCountry());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
