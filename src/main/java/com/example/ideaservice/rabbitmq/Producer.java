package com.example.ideaservice.rabbitmq;

import com.example.ideaservice.record.IdeaRecord;

public interface Producer {
    void sendMessage(IdeaRecord message);
}
