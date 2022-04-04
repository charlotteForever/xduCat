package com.web.xducatserver.controller;

import com.web.xducatserver.Entity.Cat;
import com.web.xducatserver.Repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatHandler {
    @Autowired
    private CatRepository catRepository;

    @GetMapping("/findAll")
    public List<Cat> findAll(){
        return catRepository.findAll();
    }
}
