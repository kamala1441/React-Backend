package com.rejola.BProject.master.courseCurriculam;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.mapper.ModelMapper;

import com.rejola.BProject.master.registration.RegistrationServiceImpl;
import com.rejola.BProject.shared.ResultBuilder;

@Service
public class CourseServiceImpl implements CourseService{
	private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);
	public final CourseRepo courseRepo;
	private final ModelMapper modelMapper;
	
	
	

	public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
		super();
		this.courseRepo = courseRepo;
		this.modelMapper = modelMapper;
	
	}

	@Override
	public ResponseEntity<JsonNode> saveCourse(Course course) {
        courseRepo.save(course);
         return ResponseEntity.ok(ResultBuilder.successJson("Course saved successfully"));
    }

	@Override
	public ResponseEntity<JsonNode> getAllCourses() {
		List<Course> courseList = courseRepo.findAll();
		return ResponseEntity.ok(ResultBuilder.successJson(courseList, "CourseList"));
	}

	@Override
	public ResponseEntity<JsonNode> getCourseSectionsByCourseId(Long courseId) {
		return  courseRepo.findByCourseSectionsByCourseId(courseId);
	}

}
