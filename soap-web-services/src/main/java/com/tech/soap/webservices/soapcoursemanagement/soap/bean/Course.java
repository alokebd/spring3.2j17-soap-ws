package com.tech.soap.webservices.soapcoursemanagement.soap.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private int id;
	private String name;
	private String description;

	@Override
	public String toString() {
		return String.format("Course [id=%s, name=%s, description=%s]", id, name, description);
	}

}
