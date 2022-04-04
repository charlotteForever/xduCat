package com.web.xducatserver.Repository;

import com.web.xducatserver.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {

}
