package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dao.Custom.LessionShedulDAO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.LessionsDto;

import java.util.List;

public interface LessionShedulBO extends SuperBO {

    String getStudentIdNumber(List<String> nameAndPonenumber);

    List<Enrolment> getallCoursesForStudent(String studentId);

    List<InstructorDto> getallInstroctors();

    boolean savemethod(LessionsDto dto);

    //    List<LessionsDto> listLessionDtos = lessionShedulBO.getReleventLessionObjects();
    List<LessionsDto> getReleventLessionObjects(String courseId, String date, String time, String instroctorId);


}
