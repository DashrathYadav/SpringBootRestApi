package com.example.mongoDBRestApi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mongoDBRestApi.model.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses>list; 
	CourseServiceImpl(){
		list=new ArrayList<>();
		
		list.add( new Courses( 101,"Java Spring Boot","I this course You will learn spring boot Apis"));
		list.add( new Courses( 102,"MongoDB Configuration","Learn How to use javaSpring BOOT with MongoDB "));
		
		
	}
	
	public List<Courses>getCourses(){
		return list;
	}
	
	public Courses getCourse(long courseId)
	{
		Courses c=null;
		for(Courses course:list)
		{
			if(course.getId()== courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	
	public Courses addCourse(Courses course)
	{
		list.add(course);
		return course;
	}
	

}
