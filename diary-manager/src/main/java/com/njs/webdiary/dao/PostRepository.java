package com.njs.webdiary.dao;

import com.njs.webdiary.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Integer>
{
    List<PostEntity> findByUid(int uid);

    @Modifying
    @Query(value = "update PostEntity set scanCount = scanCount + 1 where pid = :pid")
    Integer updateScanCount(int pid);

    @Modifying
    @Query(value = "update PostEntity set replyCount = replyCount + 1 where pid = :pid")
    Integer updateReplyCount(int pid);

    @Modifying
    @Query(value = "update PostEntity set replyTime = current_timestamp where pid=:pid")
    Integer updateReplyTime(@Param(value = "pid") int pid);
}
