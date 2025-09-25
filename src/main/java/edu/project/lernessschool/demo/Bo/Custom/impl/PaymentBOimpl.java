package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.PaymentBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.Impl.PaymentDAOImpl;
import edu.project.lernessschool.demo.Dao.Custom.PaymentDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class PaymentBOimpl implements PaymentBO {

    private PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOTypes.PAYMENTS);

    @Override
    public String getStudentIdNumber(String Ponenumber) {
        try {
            String studentId = paymentDAO.getStudentIdNumber(Ponenumber);
            if (studentId == null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Student is Not Found in the System give Valid pone number");
                alert.showAndWait();


            }
            return studentId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> getallCoursesForStudent(String idNumber) {

        List<Course> courses = new ArrayList<>();
        List<EnrollmentEntyty> enrollmentEntyties = paymentDAO.getallCoursesForStudent(idNumber);

        for (EnrollmentEntyty entyty : enrollmentEntyties) {

            EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
            Course course = entytyDtoConverter.getCourseDto(entyty.getCourse());
            courses.add(course);

        }

        return courses;

    }

    @Override
    public String getFirstPayment(String StudentId, String courseId) {
        try {
            String payment = paymentDAO.getFirstPayment(StudentId, courseId);
            return payment;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }


    }
}
