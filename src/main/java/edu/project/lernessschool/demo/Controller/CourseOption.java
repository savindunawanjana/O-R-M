package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.CourseBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseOption implements Initializable {
    //    public Label lblCourseId;
    public Label lblCourseId1;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public TextField txtCourseDuration;
    public ChoiceBox choisboxSelectMonth;
    //    public Label txtInstructorId;
    private CourseBO courseBO = BOFactry.getInstance().getBO(BOtypes.COURSE);
//    public ChoiceBox choisboxInstrocters;
    public Button btnReset;
    public Button btnDelete;
    public Button btnSave;
    public Button btnUpdate;
    public TableView tblCourses;
    @FXML
    private TableColumn<Course, String> colCourseId;
    @FXML
    private TableColumn<Course, String> colCourseName;
    @FXML
    private TableColumn<Course, Double> colCourseFee;
    @FXML
    private TableColumn<Course, String> colCourseDuration;


    public void btnResetOnAction(ActionEvent actionEvent) {
        refrsh();

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        String id = lblCourseId1.getText();
        String name = txtCourseName.getText();
        String fullcoursfee = txtCourseFee.getText();
//        String duration = txtCourseDuration.getText();
        String duration = choisboxSelectMonth.getSelectionModel().getSelectedItem().toString();
        System.out.println(duration);

        if ((id.isEmpty() || id.equals("")) || (name.isEmpty() || name.equals("")) || (fullcoursfee.isEmpty() || fullcoursfee.equals("")) || (duration.isEmpty() || duration.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.show();

        } else {

            Course course = new Course();
            course.setCourseId(id);
            double coursefee = Double.parseDouble(fullcoursfee);
            course.setCourseFee(coursefee);
            course.setCoureName(name);
            course.setDuretion(duration);
            Boolean rsp = courseBO.saveMethod(course);

            if (rsp == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Course Saved Successfully");
                alert.show();
                lodeNextId();
                refrsh();
            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("UnSuccess");
                alert.setHeaderText(null);
                alert.setContentText("Course Saved UnSuccessfully");
                alert.show();

            }


        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lodeNextId();
        lodeTable();
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

        choisboxSelectMonth.getItems().addAll(
                "1 Month",
                "2 Month",
                "3 Month",
                "4 Month",
                "5 Month",
                "6 Month"
        );

        // Default value set karanna
        choisboxSelectMonth.setValue("1 Month");
    }

    public void OnmouseClicked(MouseEvent mouseEvent) {
        Course course = (Course) tblCourses.getSelectionModel().getSelectedItem();

        if (course != null) {
            lblCourseId1.setText(course.getCourseId());
            txtCourseName.setText(course.getCoureName());
//            textfildPassword.setText(userDto.getPassword());
            txtCourseFee.setText(String.valueOf(course.getCourseFee()));
            choisboxSelectMonth.setValue(course.getDuretion());

            btnSave.setDisable(true);
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
        }else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("the Row is Empty plese try again");
            alert.show();
            alert.close();
            lodeTable();
            refrsh();

        }




    }


    public void lodeNextId() {
        String nextId = courseBO.getlastId();
        System.out.println("=================next id======");
        System.out.println(nextId);
        System.out.println("=======================");
        lblCourseId1.setText(nextId);

    }

    public void refrsh() {
        txtCourseName.clear();
        txtCourseFee.clear();
        choisboxSelectMonth.setValue("1 Month");
        lodeTable();
        lodeNextId();
        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }


    public void lodeTable() {

        try {
            ObservableList<Course> coursedataList = FXCollections.observableArrayList(courseBO.getCourseList());
            colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
            colCourseName.setCellValueFactory(new PropertyValueFactory<>("coureName"));
            colCourseFee.setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
            colCourseDuration.setCellValueFactory(new PropertyValueFactory<>("duretion"));

            tblCourses.setItems(coursedataList);
        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
