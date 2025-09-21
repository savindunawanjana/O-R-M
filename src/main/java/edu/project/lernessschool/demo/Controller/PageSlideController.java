package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.LessionShedulBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PageSlideController implements Initializable {

    private LessionShedulBO lessionShedulBO = BOFactry.getInstance().getBO(BOtypes.LESSIONS);
    private List<Enrolment> enrolmentsList2 = new ArrayList<>();
    public TableView tableId;
    public Label lableId;
    public TextField txtStudentname;
    public TextField txtStudentIdNumber;
    public TableView tblInstructors;
    public TableView tableKalanderId;
    public Label lblCourseId;
    public ChoiceBox ChoisBoxCourseNamesId;
    public DatePicker DatepikerId;
    public Label lblinstroctorId;
    public ChoiceBox choisboxInstructors;

    public Label lblAvelableTime;

    public Label lblStudentId;


    public TableView tbllessions;


    public Button btntuwell;
    public Button btnOne;
    public Button btnTwo;
    public Button btnThree;
    public Button btnFore;
    public Button btneight;
    public Button btnnine;
    public Button btnten;
    public Button btneleven;

    public Button btnBooknow;

    public CheckBox conformboxid2;
    public CheckBox conformboxid1;
    @FXML
    private StackPane pageHolder;

    private int currentPage = 1;
    private final int totalPages = 7; // oyāta page gana wenas karanna puluwan

    @FXML
    public void initialize() {
        showPage(1, false); // first page load
    }

    @FXML
    private void handleNext() {
        if (currentPage < totalPages) {
            currentPage++;
            showPage(currentPage, true);
        }
    }

    public void handleBefor(ActionEvent actionEvent) {
        if (currentPage > 1) {
            currentPage--;
            showPage(currentPage, false);
        }
    }

    private void showPage(int pageNumber, boolean forward) {
        pageHolder.getChildren().clear();

        // label eka hadanna
        Label label = new Label("Page " + pageNumber);
        label.setStyle("-fx-font-size: 24; -fx-text-fill: white;");

        // color change karanna
        switch (pageNumber) {
            case 1 -> {
                lableId.setText("8.00");
                label.setText("8.00");
                pageHolder.setStyle("-fx-background-color: #1e3799; -fx-alignment: center;");
            }
            case 2 -> {
                lableId.setText("9.00");
                label.setText("9.00");

                pageHolder.setStyle("-fx-background-color: #38ada9; -fx-alignment: center;");
            }
            case 3 -> {
                lableId.setText("10.00");
                label.setText("10.00");

                pageHolder.setStyle("-fx-background-color: #e58e26; -fx-alignment: center;");
            }
        }

        pageHolder.getChildren().add(label);

        // Slide Animation
//        TranslateTransition slide = new TranslateTransition(Duration.millis(600), pageHolder);
//        slide.setFromX(forward ? pageHolder.getWidth() : -pageHolder.getWidth());
//        slide.setToX(0);
//        slide.play();
    }


    public void btneightOnaction(ActionEvent actionEvent) {
    }

    public void btnnineOnAction(ActionEvent actionEvent) {
    }

    public void btntenOnaction(ActionEvent actionEvent) {
    }

    public void btnelevenOnaction(ActionEvent actionEvent) {
    }


    public void btnBooknowONaction(ActionEvent actionEvent) {
    }

    public void conformbox2ONAction(ActionEvent actionEvent) {
    }

    public void conformbox1ONAction(ActionEvent actionEvent) {

        int x = 0;

        String name = txtStudentname.getText();
        String cponeNumber = txtStudentIdNumber.getText();
        List<String> listItem = new ArrayList<String>();
        listItem.add(name);
        listItem.add(cponeNumber);
        String idNumber = lessionShedulBO.getStudentIdNumber(listItem);
        if (idNumber == null) {


        } else {
            lblStudentId.setText(idNumber);
            x = 1;
        }


        if (x == 1) {

            List<Enrolment> enrolmentsList = lessionShedulBO.getallCoursesForStudent(idNumber);
            enrolmentsList2 = enrolmentsList;
            List<String> courseIds = new ArrayList<>();
            for (Enrolment enrolment : enrolmentsList) {

                courseIds.add(enrolment.getCoursedto().getCoureName());

            }

            ChoisBoxCourseNamesId.setItems(FXCollections.observableArrayList(courseIds));
            ChoisBoxCourseNamesId.setValue("select Course");


        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChoisBoxCourseNamesId.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                //&& newVal.equals("select Course")

                if (!(enrolmentsList2 == null)) {

                    for (Enrolment enrolment : enrolmentsList2) {

                        if (newVal.equals(enrolment.getCoursedto().getCoureName())) {

                        String id = enrolment.getCoursedto().getCourseId();
                            lblCourseId.setText(id);

                        }

                    }

                }


            }
        });

    }
}
