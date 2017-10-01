package com.njs.webdiary.dao;

import com.njs.webdiary.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity,Integer>
{
    @Query("select r.rid,r.content,u.uid,u.username,u.headUrl from ReplyEntity r  join r.userByUid u  where pid=:pid")
    List<ReplyEntity> listReply(@Param(value = "pid") int pid);

}
