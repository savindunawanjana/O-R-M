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
import lombok.AllArgsConstructor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentOption implements Initializable {
    public RadioButton showbutten;
    public Button btnRefresh;
    private    List<Course> courseList2= new ArrayList<>();
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


        choisBoxCourses.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {


            if (newVal != null) {


                for( Course course : courseList2){

                    if(newVal.equals(course.getCoureName())){
                        lblCourseId.setText(course.getCourseId());

                    }
                }
            }

//            ============================================================
//            lblCourseId , lblStudentId

//            ============================================================
        });







    }

    public void rediobuttenOnaction(ActionEvent actionEvent) {

        String number = textponeNumber.getText();

        if (number == null) {


        } else {
            String id = paymentBO.getStudentIdNumber(number);
            lblStudentId.setText(id);

        }

        List<Course> courseList = paymentBO.getallCoursesForStudent( paymentBO.getStudentIdNumber(number));
        courseList2=courseList;
        List<String> names = new ArrayList<>();
        System.out.println(courseList.size());
        System.out.println("===============================");
        for (Course course : courseList) {
            names.add(course.getCoureName());
            System.out.println(course.getCoureName());
        }
        System.out.println("===============================");
        System.out.println(courseList==null);


        choisBoxCourses.setItems(FXCollections.observableArrayList(names));
        choisBoxCourses.setValue("select Course");


    }

    public void showrediobuttenOnactions(ActionEvent actionEvent) {


        if(lblCourseId==null || lblStudentId==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please Enter inputs for All above required ");

        }else {

            String payment = paymentBO.getFirstPayment(lblStudentId.getText(),lblCourseId.getText());
            lblFirstpayment.setText(payment);
            //======================zcacad==============================sda===========



        }

    }

    public void btnRefreshOnAction(ActionEvent actionEvent) {
    }
}
