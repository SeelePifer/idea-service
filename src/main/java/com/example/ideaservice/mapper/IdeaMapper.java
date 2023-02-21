package com.example.ideaservice.mapper;

import com.example.ideaservice.model.Idea;
import com.example.ideaservice.record.IdeaRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper
public interface IdeaMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "description", source = "entity.description")
    IdeaRecord toRecord(Idea entity);

    @Mapping(target = "id", source = "ideaRecord.id")
    @Mapping(target = "description", source = "ideaRecord.description")
    Idea toEntity(IdeaRecord ideaRecord);
}
