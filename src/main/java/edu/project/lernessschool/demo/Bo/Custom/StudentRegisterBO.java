package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Student;

import java.util.List;

public interface StudentRegisterBO extends SuperBO {

    boolean registerStudent(Student student);
    String getNextId();
    List<Course> getAllCourses();

}
