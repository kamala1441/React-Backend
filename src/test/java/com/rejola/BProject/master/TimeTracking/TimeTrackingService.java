package com.rejola.BProject.master.TimeTracking;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

public interface TimeTrackingService {

	ResponseEntity<JsonNode> startTime();

	ResponseEntity<JsonNode> stopTime();

}
