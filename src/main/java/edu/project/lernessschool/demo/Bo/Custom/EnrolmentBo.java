package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Dto.Enrolment;

import java.util.List;

public interface EnrolmentBo {
    List<Enrolment> getAllenrolments();

    List<Enrolment> getEnrollmentsfromIdandcourseid(String id, String course);

}
