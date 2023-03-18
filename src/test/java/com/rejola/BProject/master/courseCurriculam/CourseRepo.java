package com.rejola.BProject.master.courseCurriculam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface CourseRepo extends JpaRepository<Course,Long> {

	ResponseEntity<JsonNode> findByCourseSectionsByCourseId(Long courseId);

	void save(CourseSection courseSection);

}
