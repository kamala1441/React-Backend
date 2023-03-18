package com.rejola.BProject.master.TimeTracking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RequestMapping("/timeTracking")
@RestController
public class TimeTrackingController {

	private final TimeTrackingService timeTrackingService;
	private TimeTracking timeTracking;

	public TimeTrackingController(TimeTrackingService timeTrackingService, TimeTracking timeTracking) {
		super();
		this.timeTrackingService = timeTrackingService;
		this.timeTracking = timeTracking;
	}

	@PostMapping("/start")
	public ResponseEntity<JsonNode> startTime() {
		return timeTrackingService.startTime();
	}

	@PostMapping("/stop")
	public ResponseEntity<JsonNode> stopTime() {
		return timeTrackingService.stopTime();
	}

}
