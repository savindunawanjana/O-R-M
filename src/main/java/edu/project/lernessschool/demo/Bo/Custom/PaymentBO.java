package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.Course;

import java.util.List;

public interface PaymentBO extends SuperBO {

    String getStudentIdNumber(String Ponenumber);
  List <Course> getallCoursesForStudent(String idNumber);
}
