package com.tech.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tech.soap.webservices.soapcoursemanagement.entity.CourseEntity;
import com.tech.soap.webservices.soapcoursemanagement.repository.CourseJpaRepository;
import com.tech.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Service
public class CourseDetailsService {
	@Autowired
	private CourseJpaRepository courseJpaRepository;

	public enum Status {
		SUCCESS, FAILURE;
	}

	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Spring", "10 Steps");
		courses.add(course1);

		Course course2 = new Course(2, "Spring MVC", "10 Examples");
		courses.add(course2);

		Course course3 = new Course(3, "Spring Boot", "6K Students");
		courses.add(course3);

		Course course4 = new Course(4, "Maven", "Most popular maven course on internet!");
		courses.add(course4);
	}

	// course - 1
	public Course findById(int id) {
		Optional<CourseEntity> course = courseJpaRepository.findById(id);
		if (course.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(course.getClass(), Course.class);
		}
		/*
		 * for (Course course : courses) { if (course.getId() == id) return course; }
		 */
		return null;

	}

	// courses
	public List<Course> findAll() {
		List<CourseEntity> list = courseJpaRepository.findAll();
		if (list != null) {
			ModelMapper modelMapper = new ModelMapper();
			return list.stream().map(course -> modelMapper.map(course, Course.class)).collect(Collectors.toList());
		}
		return null;
	}

	public Status deleteById(int id) {
		/*
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
		*/
		Optional<CourseEntity> course = courseJpaRepository.findById(id);
		if (course.isPresent()) {
			courseJpaRepository.deleteById(id);
			return Status.SUCCESS;
		}	
		return Status.FAILURE;
	}
	

	// updating course & new course
}
