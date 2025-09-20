package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.StudentRegisterBO;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//CustormerOption
public class CustormerOption implements Initializable {
    public TableView tableViewId;

    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^\\d{10}$"; // Only allows 10 digit numbers
    public ChoiceBox coisboxCoursename;


    @FXML
    private TableColumn<Enrolment, String> colAction;
    @FXML
    private TableColumn<Enrolment, String> colregisterDate;
    @FXML
    private TableColumn<Enrolment, String> colStates;
    @FXML
    private TableColumn<Enrolment, String> colCourseId;

    @FXML
    private TableColumn<Enrolment, Double> colfirstPayment;

//    public TableColumn colfirstPayment;

    public Button btnReset;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;

    public Label lblStudentId;
    public TextField txtCustormerNumberId;
    public TextField txtEmailId;
    public TextField txtcourseId;

    public TextField txtAdvansId;
    public TextField txtCustormerName;

    //    public ComboBox cmbCourseNames;
    public Label courseFeeLableId;
    public Button btnAddToCart;
    StudentRegisterBO studentRegisterBO = BOFactry.getInstance().getBO(BOtypes.STUDENTREGISTEION);
    private final ObservableList<Enrolment> cartData = FXCollections.observableArrayList();


    public void tblemouseClickedEvent(MouseEvent mouseEvent) {


    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        coisboxCoursename.setValue("select Course");
        txtCustormerNumberId.clear();
        txtEmailId.clear();
        txtcourseId.clear();
        txtAdvansId.clear();
        txtCustormerName.clear();
        courseFeeLableId.setText(" Course fee");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String customerid = lblStudentId.getText();
        String custormerNumber = txtCustormerNumberId.getText();
        String custormeremail = txtEmailId.getText();
        String courseid = txtcourseId.getText();
        String firstpayment = txtAdvansId.getText();
        String name = txtCustormerName.getText();


        boolean isValidEmail = custormeremail.matches(emailPattern);
        boolean isValidPhone = custormerNumber.matches(phonePattern);

        if (isValidEmail && isValidPhone) {
            if ((customerid != null && !customerid.isEmpty()
                    && custormerNumber != null && !custormerNumber.isEmpty()
                    && custormeremail != null && !custormeremail.isEmpty()
                    && courseid != null && !courseid.isEmpty()
                    && firstpayment != null && !firstpayment.isEmpty()
                    && name != null && !name.isEmpty()) || !(cartData.isEmpty())) {

                Student student = new Student();

                student.setStudentId(customerid);
                student.setName(name);
                student.setPnumber(custormerNumber);
                student.setEmail(custormeremail);
                student.setCourse(courseid);
                //---------------------------------------
                LocalDate today = LocalDate.now();
                Date sqlDate = Date.valueOf(today);
                //---------------------------------------
                student.setRegistrationDate(sqlDate);

                student.setEnrolments(cartData);

                boolean rsp = studentRegisterBO.registerStudent(student);

                if (rsp == true) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION");
                    alert.setContentText(" Saved Successfully");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION");
                    alert.setContentText(" Saved UnSuccessfully");
                    alert.show();

                }


            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Pleas enter Data for all fields");
                alert.show();


            }


        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Invalid Email or Phone Format pleas cheak again");
            alert.show();
        }


    }

    public void cmbCourseNamesOnAction(ActionEvent actionEvent) {
    }

    public void BtnAddtocartOnAction(ActionEvent actionEvent) {

        String customerid = lblStudentId.getText();
        String custormerNumber = txtCustormerNumberId.getText();
        String custormeremail = txtEmailId.getText();
        String courseid = txtcourseId.getText();
        Course coursedto = new Course();
        coursedto.setCoureName(courseid);
        String firstpayment = txtAdvansId.getText();
        double firstpaymentfromDouble = Double.parseDouble(firstpayment);
        String name = txtCustormerName.getText();

        if (customerid != null && !customerid.isEmpty()
                && custormerNumber != null && !custormerNumber.isEmpty()
                && custormeremail != null && !custormeremail.isEmpty()
                && coursedto.getCoureName() != null && !coursedto.getCoureName().isEmpty()
                && firstpayment != null && !firstpayment.isEmpty()
                && name != null && !name.isEmpty()) {

            Enrolment enrolment = new Enrolment();

            enrolment.setEnrollmentDate(new Date(System.currentTimeMillis()));

            for (Enrolment e : cartData) {

                if (!(cartData.isEmpty())) {

                    if (coursedto.getCoureName().equals(e.getCoursedto().getCoureName())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Warning");
                        alert.setContentText(" this Course Already Exists for this Student !");
                        alert.show();

                        return;

                    }


                } else {
                    break;
                }

            }

            enrolment.setCoursedto(coursedto);

            Button Removebut = new Button("Remove");
            Removebut.setOnAction(e -> {
                cartData.remove(enrolment);
                //table.refresh();

            });
            enrolment.setRemovebutton(Removebut);
            enrolment.setFirstPayment(firstpaymentfromDouble);
            enrolment.setStatus("Active");


            cartData.add(enrolment);
            addnewDataTocartTable();


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("fill all fields !");
            alert.show();
        }


    }

    public void lodNextId() {
        String nextid = studentRegisterBO.getNextId();
        lblStudentId.setText(nextid);
        System.out.println("==========================nextID======");
        System.out.println(nextid);
        System.out.println("================================");

    }


    public void addnewDataTocartTable() {

        colregisterDate.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));
        colStates.setCellValueFactory(new PropertyValueFactory<>("status"));
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        colfirstPayment.setCellValueFactory(new PropertyValueFactory<>("firstPayment"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("removebutton"));

        tableViewId.setItems(cartData);
        tableViewId.refresh();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lodNextId();
        List<Course> clist = studentRegisterBO.getAllCourses();
        ArrayList<String> namesList = new ArrayList<>();
        for (Course c : clist) {
            String name = c.getCoureName();
            namesList.add(name);
        }
        coisboxCoursename.setValue("select Course");
        coisboxCoursename.setItems(FXCollections.observableArrayList(namesList));
        coisboxCoursename.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                //&& newVal.equals("select Course")

                for (Course course : clist) {

                    if (newVal.equals(course.getCoureName())) {
                        System.out.println(course.getCoureName());
                        System.out.println(course.getCourseFee());
                        courseFeeLableId.setText(String.valueOf(course.getCourseFee()));
                        txtcourseId.setText(course.getCoureName());

                    }

                }
            }
        });

    }
}
