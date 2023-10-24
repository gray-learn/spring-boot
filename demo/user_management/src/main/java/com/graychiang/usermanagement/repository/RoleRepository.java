package com.graychiang.usermanagement.repository;

import com.graychiang.usermanagement.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : user_management
 * User: graychiang

 * Date:
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String role);
}