package com.example.ideaservice.mapper;

import com.example.ideaservice.model.Idea;
import com.example.ideaservice.record.IdeaRecord;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdeaMapperTest {

    private IdeaMapper ideaMapper = Mappers.getMapper(IdeaMapper.class);
    @Test
    public void MapEntitytoRecordWithMapper(){
        Idea idea = new Idea();
        idea.setId(1L);
        idea.setDescription("asd");

        final var ideaRecord = ideaMapper.toRecord(idea);
        assertEquals(idea.getId(), ideaRecord.id());
        assertEquals(idea.getDescription(), ideaRecord.description());
    }
    @Test
    public void MapRecordToEntityWithMapper(){
        IdeaRecord ideaRecord = new IdeaRecord(1L, "asd");

        final var idea = ideaMapper.toEntity(ideaRecord);

        assertEquals(ideaRecord.description(), idea.getDescription());
        assertEquals(ideaRecord.id(), idea.getId());

    }
}
