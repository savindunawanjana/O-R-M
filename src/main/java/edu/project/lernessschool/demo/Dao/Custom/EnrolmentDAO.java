package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.CrudDAO;
import edu.project.lernessschool.demo.Dao.SuperDAO;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;

import java.util.List;

public interface EnrolmentDAO extends CrudDAO<Enrolment> {

    List<EnrollmentEntyty> getAllenrolments();
    List<EnrollmentEntyty> getEnrollmentsfromIdandcourseid(String id , String course);


}
