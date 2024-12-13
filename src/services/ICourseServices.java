package services;

import java.util.List;

import modules.Course;



public interface ICourseServices {
	List<Course> selectCoursesByFilliere(int filliereID);
	List<Course> selectCoursesByFilliereTitle(String filliereTitle);
	boolean insertCours(Course course);
	
}
