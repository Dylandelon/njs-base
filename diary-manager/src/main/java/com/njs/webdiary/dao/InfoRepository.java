package com.njs.webdiary.dao;

import com.njs.webdiary.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoEntity,Integer>
{
}
