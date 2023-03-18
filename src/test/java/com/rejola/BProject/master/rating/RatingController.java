package com.rejola.BProject.master.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    

    public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	@PostMapping
	private ResponseEntity<JsonNode> saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping("/item/{itemId}")
    private ResponseEntity<JsonNode> getRatingsForCourse(@PathVariable Long courseId) {
        return ratingService.getRatingsForCourse(courseId);
    }
}
