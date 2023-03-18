package com.rejola.BProject.master.rating;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RatingDto implements Serializable {
	  private Long id;
	    private Long userId;
	    private Long courseId;
	    private Integer rating;
	    private LocalDateTime timestamp;
}
