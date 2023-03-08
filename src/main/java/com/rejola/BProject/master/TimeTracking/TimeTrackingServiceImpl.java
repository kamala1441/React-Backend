package com.rejola.BProject.master.TimeTracking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rejola.BProject.mapper.ModelMapper;
import com.rejola.BProject.master.registration.RegistrationServiceImpl;
import com.rejola.BProject.shared.ResultBuilder;

@Service
public class TimeTrackingServiceImpl implements TimeTrackingService {
	private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);
	public final TimeTrackingRepo timeTrackingRepo;
	private final ModelMapper modelMapper;
	private TimeTracking timeTracking;

	public TimeTrackingServiceImpl(TimeTrackingRepo timeTrackingRepo, ModelMapper modelMapper,
			TimeTracking timeTracking) {
		super();
		this.timeTrackingRepo = timeTrackingRepo;
		this.modelMapper = modelMapper;
		this.timeTracking = timeTracking;
	}

	@Override
	public ResponseEntity<JsonNode> startTime() {
		timeTracking = new TimeTracking();
		timeTracking.setStartTime(System.currentTimeMillis());
		return ResponseEntity.ok(ResultBuilder.successJson("Time started"));
	}

	@Override
	public ResponseEntity<JsonNode> stopTime() {
		timeTracking.setEndTime(System.currentTimeMillis());
		long elapsedTime = timeTracking.getEndTime() - timeTracking.getStartTime();
		return ResponseEntity.ok(ResultBuilder.successJson(elapsedTime, "Time Ended"));
	}

}
