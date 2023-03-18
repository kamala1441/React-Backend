package com.rejola.BProject.master.rating;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface RatingService {

	ResponseEntity<JsonNode> saveRating(Rating rating);

	ResponseEntity<JsonNode> getRatingsForCourse(Long courseId);

}
