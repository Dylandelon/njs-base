package com.njs.webdiary.dao;

import com.njs.webdiary.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity,Integer>
{
    @Query(value = "select image_url from image",nativeQuery = true)
    List<String> listImage();
}
