package com.rejola.BProject.master.rating;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.master.chat.ChatRepo;
import com.rejola.BProject.master.registration.RegistrationServiceImpl;
import com.rejola.BProject.shared.ResultBuilder;

@Service
public class RatingServiceImpl implements RatingService{
	public final RatingRepo ratingRepo;
	private final ModelMapper modelMapper;
	
	
	public RatingServiceImpl(com.rejola.BProject.master.rating.RatingRepo ratingRepo, ModelMapper modelMapper) {
		super();
		this.ratingRepo = ratingRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<JsonNode> saveRating(Rating rating) {
		 rating.setTimestamp(LocalDateTime.now());
	         ratingRepo.save(rating);
	         return ResponseEntity.ok(ResultBuilder.successJson("Rating created"));
	    }

	@Override
	public ResponseEntity<JsonNode> getRatingsForCourse(Long courseId) {
		 return  ratingRepo.findByCourseId(courseId);
	   //return ResponseEntity.ok(ResultBuilder.successJson("Rating created"));
	}
}
