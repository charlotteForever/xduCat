package com.web.xducatserver.controller;

import com.web.xducatserver.Entity.Comment;
import com.web.xducatserver.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value="/findCommentByCatId/{Id}")
    public List<Comment> findCommentByCatId(@PathVariable Integer Id){
        return commentRepository.findCommentByCatId(Id);
    }

    @RequestMapping(value = "/insertComment/{id}/{comment}/{name}")
    public boolean insertComment(@PathVariable Integer id,@PathVariable String comment, @PathVariable String name) {

        try{
            java.util.Date nowDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(nowDate.getTime());
            commentRepository.insertComment(id,comment,name,sqlDate);
        }catch (Exception e){
            return false;
        }

        return true;
    }

}

