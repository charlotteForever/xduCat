package com.web.xducatserver.Repository;

import com.web.xducatserver.Entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Integer> {
}
