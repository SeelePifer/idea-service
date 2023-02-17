package com.example.ideaservice.controller;

import com.example.ideaservice.rabbitmq.RabbitMQProducer;
import com.example.ideaservice.record.IdeaRecord;
import com.example.ideaservice.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

   @Autowired
   private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/ideas")
    public List<IdeaRecord> getIdeas(){
        return ideaService.getIdeas();
    }
    @GetMapping("/publish/ideas")
    public String sendMessage(@RequestBody IdeaRecord idea){
        rabbitMQProducer.sendMessage(idea);
        return "Message Sent";
    }
}
