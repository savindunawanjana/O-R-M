package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.LessionShedulBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.LessionsDto;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PageSlideController implements Initializable {

    private  int []i =new int[1];
    private ObservableList<LessionsDto> data = FXCollections.observableArrayList();
    private List<String> instructorsIds = new ArrayList<>();
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
    private TableColumn<InstructorDto, String> colInstructorId;
    @FXML
    private TableColumn<InstructorDto, String> colInstructorname;
    @FXML
    private TableColumn<InstructorDto, String> colInstructorNumber;


    @FXML
    private StackPane pageHolder;

    private int currentPage = 3;
    private final int totalPages = 9; // oyāta page gana wenas karanna puluwan

    @FXML
    public void initialize() {
        showPage(3, false); // first page load
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

        TableView<LessionsDto> tableView = new TableView<>();

        TableColumn<LessionsDto, String> colInstructorId = new TableColumn<>("Instructor ID");
        colInstructorId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));

        TableColumn<LessionsDto, String> colStudentId = new TableColumn<>("Student Id");
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        TableColumn<LessionsDto, String> colDate = new TableColumn<>("Date");
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tableView.getColumns().addAll(colInstructorId, colStudentId, colDate);

        // Page → Time mapping
        String time = switch (pageNumber) {
            case 1 -> "8.00";
            case 2 -> "9.00";
            case 3 -> "10.00";
            case 4 -> "11.00";
            case 5 -> "12.00";
            case 6 -> "1.00";
            case 7 -> "2.00";
            case 8 -> "3.00";
            case 9 -> "4.00";
            default -> null;
        };

        lableId.setText(time);

        // Background color
        switch (pageNumber) {
            case 1, 4, 7 -> pageHolder.setStyle("-fx-background-color: #1e3799; -fx-alignment: center;");
            case 2, 5, 8 -> pageHolder.setStyle("-fx-background-color: #38ada9; -fx-alignment: center;");
            case 3, 6, 9 -> pageHolder.setStyle("-fx-background-color: #e58e26; -fx-alignment: center;");
        }

        // ====== Main Fix ======
        i[0] = pageNumber;           // 🔑 Next / Before walata `i[0]` update wenawa
        lodePageData(time);          // 🔑 always data load karanna

        tableView.setItems(data);
        pageHolder.getChildren().add(tableView);
    }




    public void btneightOnaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("8.00");
        i[0]=1;
    }

    public void btnnineOnAction(ActionEvent actionEvent) {
        lblAvelableTime.setText("9.00");
        i[0]=2;
    }


    public void btntenOnaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("10.00");
        i[0]=3;
    }

    public void btnelevenOnaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("11.00");
        i[0]=4;
    }


    public void btn12Onaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("12.00");
        i[0]=5;
    }

    public void btn1Onaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("1.00");
        i[0]=6;
    }

    public void btn2Onaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("2.00");
        i[0]=7;
    }

    public void btn3Onaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("3.00");
        i[0]=8;
    }

    public void btn4Onaction(ActionEvent actionEvent) {
        lblAvelableTime.setText("4.00");
        i[0]=9;
    }


    public void conformbox1ONAction(ActionEvent actionEvent) {

        int x = 0;


        String name = txtStudentname.getText();
        String cponeNumber = txtStudentIdNumber.getText();
        List<String> listItem = new ArrayList<String>();
        listItem.add(name);
        listItem.add(cponeNumber);
        String idNumber = lessionShedulBO.getStudentIdNumber(listItem);


        if (name.equals("") || name == null) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter student name");
            alert.showAndWait();


        }
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

//    private void resetChoiceBoxes() {

    /// /        ChoisBoxCourseNamesId.getItems().clear();
    /// /        ChoisBoxCourseNamesId.setValue(null);
//
//        choisboxInstructors.getItems().clear();
//        choisboxInstructors.setValue(null);
//
//        lblCourseId.setText("");
//        lblinstroctorId.setText("");
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ChoisBoxCourseNamesId.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            instructorsIds.clear();

            if (newVal != null) {
                //&& newVal.equals("select Course")

                if (!(enrolmentsList2 == null)) {

                    for (Enrolment enrolment : enrolmentsList2) {

                        if (newVal.equals(enrolment.getCoursedto().getCoureName())) {

                            String id = enrolment.getCoursedto().getCourseId();
                            lblCourseId.setText(id);

                        }
                    }


                    List<InstructorDto> instructorDtos = lessionShedulBO.getallInstroctors();
                    System.out.println(newVal);
                    for (InstructorDto instructorDto : instructorDtos) {

                        if (newVal.equals(instructorDto.getInstructorSpeciality())) {

                            instructorsIds.add(instructorDto.getInstructorId());


                        }


                    }

//                        List<InstructorDto> instructorDtos2 = new ArrayList<>();
//
//                        int length = instructorsIds.size();
//                        int i=0;
//
//                        for (InstructorDto instructorDto : instructorDtos) {
//
//
//                            if (instructorDto.getInstructorId().equals(instructorsIds.get(i))) {
//
//                                instructorDtos2.add(instructorDto);
//                                i++;
////                            if(i>length){
////                                break;
////
////                            }
//
//                            }
//
//
//                        }

                    List<InstructorDto> instructorDtos2 = new ArrayList<>();

                    for (InstructorDto instructorDto : instructorDtos) {
                        if (instructorsIds.contains(instructorDto.getInstructorId())) {
                            instructorDtos2.add(instructorDto);
                        }
                    }

                    ObservableList<InstructorDto> observableInstructors = FXCollections.observableArrayList(instructorDtos2);


                    colInstructorId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
                    colInstructorname.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
                    colInstructorNumber.setCellValueFactory(new PropertyValueFactory<>("instructorPhone"));

                    tblInstructors.setItems(observableInstructors);
                    tblInstructors.refresh();


                    // =====================================================================
                    for (String id : instructorsIds) {
                        System.out.println(id);

                    }
                    //=====================================================================

//                    choisboxInstructors.getItems().clear();

                    choisboxInstructors.setItems(FXCollections.observableArrayList(instructorsIds));
                    choisboxInstructors.setValue("select Instructor");
                    //=============


                }


            }
        });

        choisboxInstructors.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {


            if (newVal != null) {

                lblinstroctorId.setText(newVal.toString());


            }


        });

    }


    public List<LessionsDto> getReleventLessionObject(String courseId, String date, String time, String instroctorId) {

        List<LessionsDto> listLessionDtos = lessionShedulBO.getReleventLessionObjects(courseId, date, time, instroctorId);
        if (listLessionDtos == null) {

            System.out.println("Meka null");


        }
//        System.out.println(listLessionDtos.get(0).toString());
//        System.out.println("=========================");
        return listLessionDtos;

    }


    public void btnBooknowONaction(ActionEvent actionEvent) {

        String instroctorIds = lblinstroctorId.getText();
        String coursId = lblCourseId.getText();
        String studentId = lblStudentId.getText();
        String state = "Active";
        String times = lblAvelableTime.getText();

        LocalDate selectedDate = DatepikerId.getValue();




        String dates = (selectedDate != null) ? selectedDate.toString() : null;

        if (instroctorIds == null || instroctorIds.isEmpty() ||
                coursId == null || coursId.isEmpty() ||
                studentId == null || studentId.isEmpty() ||
                state == null || state.isEmpty() ||
                times == null || times.isEmpty() ||
                dates == null || dates.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please enter values for all fields");
            alert.show();
            return; // stop execution
        } else {

            LessionsDto dto = new LessionsDto();
            dto.setInstructorId(instroctorIds);
            dto.setCourseId(coursId);
            dto.setStudentId(studentId);
            dto.setStatus(state);
            dto.setTime(times);
            dto.setDate(dates);

            boolean rsp = lessionShedulBO.savemethod(dto);

            if (rsp) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Save Successful");
                alert.show();
                clearmethod();

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(" It has not Saved ! ");
                alert.show();
            }


        }


    }


    public void conformbox2ONAction(ActionEvent actionEvent) {
    }


    public void lodePageData(String time) {
        String coursId = lblCourseId.getText();
        LocalDate selectedDate = DatepikerId.getValue();
        String dates = (selectedDate != null) ? selectedDate.toString() : null;
        String instroctorIds = lblinstroctorId.getText();

        if (coursId != null && dates != null && time != null && instroctorIds != null) {
            List<LessionsDto> Lessionsdtos = getReleventLessionObject(coursId, dates, time, instroctorIds);
            data = FXCollections.observableArrayList(Lessionsdtos);
        } else {
            data = FXCollections.observableArrayList();
        }
    }

    public void clearmethod() {
        lblinstroctorId.setText("");
        lblCourseId.setText("");
        lblStudentId.setText("");
        lblAvelableTime.setText("");
        DatepikerId.setValue(null);


    }




}
