package services;

import java.util.List;

import modules.Course;



public interface ICourseServices {
	List<Course> selectCoursesByFilliere(int filliereID);
	boolean insertCours(Course course);
}
