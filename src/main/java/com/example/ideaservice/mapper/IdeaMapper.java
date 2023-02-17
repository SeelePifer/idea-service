package com.example.ideaservice.mapper;

import com.example.ideaservice.model.Idea;
import com.example.ideaservice.record.IdeaRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface IdeaMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "description", source = "entity.description")
    IdeaRecord toRecord(Idea entity);

    @Mapping(target = "id", source = "record.id")
    @Mapping(target = "description", source = "record.description")
    Idea toEntity(IdeaRecord record);
}
