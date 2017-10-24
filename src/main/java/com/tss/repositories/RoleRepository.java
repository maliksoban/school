package com.tss.repositories;

import com.tss.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by MalikSoban on 31/08/2017.
 */

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
