package com.njs.webdiary.dao;

import com.njs.webdiary.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity,Integer>
{
}
