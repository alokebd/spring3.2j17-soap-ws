package com.tech.soap.webservices.soapcoursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.soap.webservices.soapcoursemanagement.entity.CourseEntity;

public interface CourseJpaRepository extends JpaRepository<CourseEntity, Integer>{

}
