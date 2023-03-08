package com.rejola.BProject.master.courseCurriculam;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface CourseService  {

	ResponseEntity<JsonNode> saveCourse(Course course);

	ResponseEntity<JsonNode> getAllCourses();

	ResponseEntity<JsonNode> getCourseSectionsByCourseId(Long courseId);


}
