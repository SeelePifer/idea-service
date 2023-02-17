package com.example.ideaservice.service;

import com.example.ideaservice.mapper.IdeaMapper;
import com.example.ideaservice.model.Idea;
import com.example.ideaservice.record.IdeaRecord;
import com.example.ideaservice.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;

    @Autowired
    private  IdeaMapper mapper;

    public IdeaServiceImpl(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }


    @Override
    public List<IdeaRecord> getIdeas() {
        List<Idea> ideas = ideaRepository.getIdeas();
        List<IdeaRecord> ideaRecords = ideas.stream()
                .map(mapper::toRecord)
                .collect(Collectors.toList());

        return ideaRecords;

    }
}
