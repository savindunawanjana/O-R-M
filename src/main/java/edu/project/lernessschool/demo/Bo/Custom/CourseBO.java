package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;

import java.util.List;

public interface CourseBO extends SuperBO {
    Boolean saveMethod(Course dto);
    Boolean updatdMethod(Course dto);
    Boolean deleteMethod(Course dto);
    String getlastId();
    List<Course> getCourseList();
}
