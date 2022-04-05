package com.web.xducatserver.Repository;

import com.web.xducatserver.Entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat,Integer> {

    @Query(value="select * from cat where color like %?1%",nativeQuery=true)
    public List<Cat> findCatByColor(String color);


}