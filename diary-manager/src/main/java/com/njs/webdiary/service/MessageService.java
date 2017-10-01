package com.njs.webdiary.service;


import com.njs.webdiary.dao.MessageRepository;
import com.njs.webdiary.entity.MessageEntity;
import com.njs.webdiary.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    //获得消息列表
    public Map<String, List<MessageEntity>> findAll(Integer sessionUid) {
        List<MessageEntity> messageList = messageRepository.findByUid(sessionUid);
        Map<String, List<MessageEntity>> map = new HashMap<>();
        for(MessageEntity message : messageList){
            String time = MyUtil.formatDate(message.getMsgTime()).substring(0,11);
            if(map.get(time)==null){
                map.put(time,new LinkedList<MessageEntity>());
                map.get(time).add(message);
            }else{
                map.get(time).add(message);
            }
        }
        return map;
    }
}
