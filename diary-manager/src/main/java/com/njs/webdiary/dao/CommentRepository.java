package com.njs.webdiary.dao;

import com.njs.webdiary.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Long>
{
    @Query(value = "select c.cid,c.content,u.uid,u.username,u.head_url from CommentEntity c join user u on c.uid=u.uid where rid=:rid",nativeQuery = true)
    List<CommentEntity> listComment(Integer rid);
}
