package com.njs.webdiary.service;

import com.njs.webdiary.dao.ImageRepository;
import com.njs.webdiary.dao.TopicRepository;
import com.njs.webdiary.entity.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {


    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ImageRepository imageRepository;

    public List<TopicEntity> listTopic() {
        return topicRepository.findAll();
    }

    public List<String> listImage() {
        return imageRepository.listImage();
    }
}

