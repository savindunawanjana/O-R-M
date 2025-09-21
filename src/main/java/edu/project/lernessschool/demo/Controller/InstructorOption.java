package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.InstructorBO;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InstructorOption implements Initializable {

    public Button btnReset;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;

    public TextField textfildName;
    public TextField textfildEmail;
    public TextField textfildSpesiality;
    public TextField textfildCnumber;
    public Label lblInstructorId;
    public TableView tableId;
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^\\d{10}$"; // Only allows 10 digit numbers
    public ChoiceBox choisBoxForSpecility;

    private InstructorBO instructorBO = BOFactry.getInstance().getBO(BOtypes.INSTRUCTOR);


    @FXML
    private TableColumn<InstructorDto, String> colIdInstroctor;
    @FXML
    private TableColumn<InstructorDto, String> colNameInstroctor;
    @FXML
    private TableColumn<InstructorDto, String> colEmailInstroctor;
    @FXML
    private TableColumn<InstructorDto, String> colSpeciality;
    @FXML
    private TableColumn<InstructorDto, String> colNumber;

    public void btnResetOnAction(ActionEvent actionEvent) {
        clearmethod();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = lblInstructorId.getText();
        String name = textfildName.getText();
        String email = textfildEmail.getText();
        String Spesiality = textfildSpesiality.getText();
        String ContactNumber = textfildCnumber.getText();


        if (!(id.equals("") || id.isEmpty()) && !(name.equals("") || name.isEmpty()) && !(email.equals("") || email.isEmpty()) && !(Spesiality.equals("") || Spesiality.isEmpty()) && !(ContactNumber.equals("") || ContactNumber.isEmpty())) {

            if (true) {
                InstructorDto dto = new InstructorDto(id, name, email, Spesiality, ContactNumber);

                Boolean rsp = instructorBO.deleteMethod(dto);
                if (rsp == true) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor Delete successfully ");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor Delete Unsuccessfully !");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();

                }


            }
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("please enter  Data for all text fild");
            alert.show();
            clearmethod();
            LodeTableData();
            lodenextId();


        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        String id = lblInstructorId.getText();
        String name = textfildName.getText();
        String email = textfildEmail.getText();
        String Spesiality = textfildSpesiality.getText();
        String ContactNumber = textfildCnumber.getText();

        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = ContactNumber.matches(phonePattern);

        if (!(id.equals("") || id.isEmpty()) && !(name.equals("") || name.isEmpty()) && !(email.equals("") || email.isEmpty()) && !(Spesiality.equals("") || Spesiality.isEmpty()) && !(ContactNumber.equals("") || ContactNumber.isEmpty())) {

            if (isValidEmail && isValidPhone) {
                InstructorDto dto = new InstructorDto(id, name, email, Spesiality, ContactNumber);

                Boolean rsp = instructorBO.updatdMethod(dto);
                if (rsp == true) {


                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor Update successfully ");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor Update Unsuccessfully !");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();

                }


            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Email or Phone Number please cheak again");
                alert.show();
                clearmethod();
                LodeTableData();
                lodenextId();

            }
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("please enter  Data for all text fild");
            alert.show();
            clearmethod();

        }


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        String id = lblInstructorId.getText();
        String name = textfildName.getText();
        String email = textfildEmail.getText();
        String Spesiality = textfildSpesiality.getText();
        String ContactNumber = textfildCnumber.getText();

        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = ContactNumber.matches(phonePattern);

        if (!(id.equals("") || id.isEmpty()) && !(name.equals("") || name.isEmpty()) && !(email.equals("") || email.isEmpty()) && !(Spesiality.equals("") || Spesiality.isEmpty()) && !(ContactNumber.equals("") || ContactNumber.isEmpty())) {

            if (isValidEmail && isValidPhone) {
                InstructorDto dto = new InstructorDto(id, name, email, Spesiality, ContactNumber);

                Boolean rsp = instructorBO.saveMethod(dto);
                if (rsp == true) {


                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor saved successfully ");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();


                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Instructor saved Unsuccessfully !");
                    alert.show();
                    clearmethod();
                    LodeTableData();
                    lodenextId();

                }


            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Invalid Email or Phone Number please cheak again");
                alert.show();
//                clearmethod();
               LodeTableData();
//                lodenextId();

            }
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("please enter  Data for all text fild");
            alert.show();
            clearmethod();
            LodeTableData();
            lodenextId();


        }


    }

    public void tableOnmousClicked(MouseEvent mouseEvent) {
        InstructorDto instructorDto = (InstructorDto) tableId.getSelectionModel().getSelectedItem();

        if (instructorDto != null) {
            lblInstructorId.setText(instructorDto.getInstructorId());
            textfildEmail.setText(instructorDto.getInstructorEmail());
            textfildName.setText(instructorDto.getInstructorName());
            textfildCnumber.setText(instructorDto.getInstructorPhone());
            textfildSpesiality.setText(instructorDto.getInstructorSpeciality());
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
            LodeTableData();
            clearmethod();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      List <String>coursename = instructorBO.getCoursename();
                choisBoxForSpecility.setItems(FXCollections.observableArrayList(coursename));
        choisBoxForSpecility.setValue("Select speciality");


        choisBoxForSpecility.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {

                textfildSpesiality.setText(newVal.toString());

            }
        });

        LodeTableData();
        lodenextId();

    }


    public void lodenextId() {

        try {
            InstructorDto dto = instructorBO.getlastId();
            if (dto == null) {

                lblInstructorId.setText("I001");

            } else {
                lblInstructorId.setText(dto.getInstructorId());
//                System.out.println(dto.getInstructorId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearmethod() {
        textfildName.setText("");
        textfildEmail.setText("");
        textfildSpesiality.setText("");
        textfildCnumber.setText("");
        lodenextId();
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);

    }

    public void LodeTableData() {
        ObservableList<InstructorDto> cach = FXCollections.observableArrayList(instructorBO.getInstroctorList());
        colIdInstroctor.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
        colNameInstroctor.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        colEmailInstroctor.setCellValueFactory(new PropertyValueFactory<>("instructorEmail"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("instructorSpeciality"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("instructorPhone"));
        tableId.setItems(cach);

    }

}
