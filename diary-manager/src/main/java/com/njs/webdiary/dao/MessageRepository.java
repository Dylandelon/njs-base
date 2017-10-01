package com.njs.webdiary.dao;

import com.njs.webdiary.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity,Integer>
{
    List<MessageEntity> findByUid(int uid);
}
