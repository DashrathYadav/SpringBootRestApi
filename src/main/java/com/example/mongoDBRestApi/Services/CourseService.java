package com.example.mongoDBRestApi.Services;

import java.util.List;

import com.example.mongoDBRestApi.model.Courses;

public interface CourseService {

	public List<Courses>getCourses();
	public Courses getCourse(long courseId);
	public Courses addCourse(Courses course);
}

