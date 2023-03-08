package com.rejola.BProject.master.rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface RatingRepo extends JpaRepository<Rating,Long>{

	ResponseEntity<JsonNode> findByCourseId(Long courseId);

}
