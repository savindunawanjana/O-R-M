package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.LessionShedulBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.LessionShedulDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class LessionShedulBOImpl implements LessionShedulBO {
    private LessionShedulDAO lessionShedulDAO = DAOFactory.getInstance().getDAO(DAOTypes.LESSIONS);

    @Override
    public String getStudentIdNumber(List<String> nameAndPonenumber) {
        try {
            String studentId = lessionShedulDAO.getStudentIdNumber(nameAndPonenumber);
            if (studentId == null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Student ID Not Found");
                alert.showAndWait();


            }
            return studentId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Enrolment> getallCoursesForStudent(String studentId) {
        try {

            List<EnrollmentEntyty> entyty = lessionShedulDAO.getallCoursesForStudent(studentId);
            List<Enrolment> enrolments = new ArrayList<>();
            EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();

            for (EnrollmentEntyty e : entyty) {
                Enrolment dto = enttyDtoConverter.getEnrolmentDto(e);
                System.out.println(dto.getCoursedto().getCourseId());
                enrolments.add(dto);
            }
            return enrolments;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
