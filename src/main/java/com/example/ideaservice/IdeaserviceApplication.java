package com.example.ideaservice;

import com.example.ideaservice.controller.IdeaController;
import com.example.ideaservice.mapper.IdeaMapper;
import com.example.ideaservice.rabbitmq.RabbitMQProducer;
import com.example.ideaservice.repository.IdeaRepository;
import com.example.ideaservice.service.IdeaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = IdeaController.class)
@ComponentScan(basePackageClasses = IdeaService.class)
@ComponentScan(basePackageClasses = IdeaRepository.class)
@ComponentScan(basePackageClasses = RabbitMQProducer.class)
@ComponentScan("com.example.ideaservice.mapper")
public class IdeaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeaserviceApplication.class, args);
    }

}
