package com.rejola.BProject.master.courseCurriculam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.master.chat.Chat;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courseDetails")

	public ResponseEntity<JsonNode> getAllCourses() {
		return courseService.getAllCourses();
	}

	@PostMapping("/course")
	private ResponseEntity<JsonNode> saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}

	@GetMapping("/{courseId}/sections")
	public ResponseEntity<JsonNode> getCourseSectionsByCourseId(@PathVariable Long courseId) {
		return courseService.getCourseSectionsByCourseId(courseId);
	}

	@PostMapping("/sections")
	private ResponseEntity<JsonNode> saveCourseSection(@RequestBody CourseSection courseSection) {
		return courseService.saveCourseSection(courseSection);
	}
}
