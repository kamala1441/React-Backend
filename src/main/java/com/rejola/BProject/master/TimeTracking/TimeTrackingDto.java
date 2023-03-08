package com.rejola.BProject.master.TimeTracking;

import java.io.Serializable;

public class TimeTrackingDto implements Serializable {
	private Long id;
    private long startTime;
    private long endTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
    
}
