package com.example.ideaservice.mapper;

import com.example.ideaservice.model.Idea;
import com.example.ideaservice.record.IdeaRecord;



public class IdeaMapperImpl {

    private IdeaMapper ideaMapper;

    public IdeaRecord toRecord(Idea entity) {
        return ideaMapper.toRecord(entity);
    }


    public Idea toEntity(IdeaRecord record) {
        return ideaMapper.toEntity(record);
    }
}
