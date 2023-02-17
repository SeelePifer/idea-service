package com.example.ideaservice.rabbitmq;

import com.example.ideaservice.record.IdeaRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer implements Producer {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);


    private ObjectMapper objectMapper = new ObjectMapper();

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(IdeaRecord message){
        try{
            String jsonString = objectMapper.writeValueAsString(message);
            LOGGER.info(String.format("Message sent -> %s", jsonString));
            rabbitTemplate.convertAndSend(queue.getName(), jsonString);

        }catch (JsonProcessingException e){
            LOGGER.error("Error converting message to JSON"+e);
        }
    }
}
