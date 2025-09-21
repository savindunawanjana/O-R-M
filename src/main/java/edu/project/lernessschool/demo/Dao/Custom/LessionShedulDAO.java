package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.CrudDAO;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.LessionsEntyty;

import java.util.List;

public interface LessionShedulDAO extends CrudDAO<LessionsEntyty> {
    String getStudentIdNumber(List<String> nameAndPonenumber) throws Exception;
    List<EnrollmentEntyty> getallCoursesForStudent(String studentId) throws Exception;
}
