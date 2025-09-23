package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.CrudDAO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.PaymentEntyty;

import java.util.List;

public interface PaymentDAO extends CrudDAO<PaymentEntyty> {
    String getStudentIdNumber(String ponenumber) throws Exception;
    List<EnrollmentEntyty> getallCoursesForStudent(String idNumber);
}
