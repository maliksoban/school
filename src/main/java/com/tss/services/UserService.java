package com.tss.services;

import com.tss.domain.User;
import com.tss.dto.UserDTO;

import java.util.List;

/**
 * Created by MalikSoban on 31/08/2017.
 */
public interface UserService {

    void saveOrUpdate(User user);

    void create(UserDTO userDTO);

    User getUserById(Integer id);

    User findUserExist(UserDTO userDTO);

    List<User> getDeletedUser(Integer id);
}
