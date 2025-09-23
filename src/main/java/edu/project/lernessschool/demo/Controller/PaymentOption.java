package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.PaymentBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentOption implements Initializable {

    public RadioButton rediobuttenId;
    private PaymentBO paymentBO = BOFactry.getInstance().getBO(BOtypes.PAYMENTS);
    public TextField textponeNumber;
    public ChoiceBox choisBoxCourses;
    public TextField textPaymentfild;
    public Label lblstate;
    public Label lblCourseId;
    public Label lblFirstpayment;

    public TableView tblId;
    public TableColumn colStudentId;
    public TableColumn colstetus;
    public TableColumn colPayment;
    public TableColumn colDate;

    public Button btnpay;
    public Label lblStudentId;

    public void saveButtenOnaction(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void rediobuttenOnaction(ActionEvent actionEvent) {

        String number = textponeNumber.getText();

        if (number == null) {


        } else {
            String id = paymentBO.getStudentIdNumber(number);
            lblStudentId.setText(id);

        }


        List<Course> courseList = paymentBO.getallCoursesForStudent(number);
        List<String> names = new ArrayList<>();

        for (Course course : courseList) {
            names.add(course.getCoureName());

        }


        choisBoxCourses.setItems(FXCollections.observableArrayList(names));
        choisBoxCourses.setValue("select Course");

        //   List<Enrolment> enrolmentsList = lessionShedulBO.getallCoursesForStudent(idNumber);

//        enrolmentsList2 = enrolmentsList;
//        List<String> courseIds = new ArrayList<>();
//        for (Enrolment enrolment : enrolmentsList) {
//
//            courseIds.add(enrolment.getCoursedto().getCoureName());
//
//        }
//
//        ChoisBoxCourseNamesId.setItems(FXCollections.observableArrayList(courseIds));
//        ChoisBoxCourseNamesId.setValue("select Course");


    }
}
