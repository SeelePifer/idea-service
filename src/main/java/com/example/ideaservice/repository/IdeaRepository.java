package com.example.ideaservice.repository;


import com.example.ideaservice.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
    @Query(nativeQuery = true, value = """
        SELECT id, description 
        FROM idea
""")
    List<Idea> getIdeas();

}
