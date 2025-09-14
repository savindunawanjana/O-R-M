package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.UserManegementBO;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserOption implements Initializable {
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^\\d{10}$"; // Only allows 10 digit numbers

    public TableView tableViewId;

    @FXML
    private TableColumn<UserDto, String> colUserID;
    @FXML
    private TableColumn<UserDto, String> colUserRollId;
    @FXML
    private TableColumn<UserDto, String> colUsername;
    @FXML
    private TableColumn<UserDto, String> colCnumber;
    @FXML
    private TableColumn<UserDto, String> colUserPassword;

    @FXML
    private TableColumn<UserDto, String> coluserEmail;


    public Button btnReset;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;

    public TextField textfildUserRolle;
    public TextField textfildPassword;
    public TextField textfildUsername;
    public TextField textfildCnumber;
    public TextField txtEmailAdressId;
    public Label lblUserId;


    private UserManegementBO userManegementBO = BOFactry.getInstance().getBO(BOtypes.UserManegement);

    public void tblemouseClickedEvent(MouseEvent mouseEvent) {
        UserDto userDto = (UserDto) tableViewId.getSelectionModel().getSelectedItem();

        if (userDto != null) {
            lblUserId.setText(userDto.getUserid());
            textfildUserRolle.setText(userDto.getUserroll());
//            textfildPassword.setText(userDto.getPassword());
            textfildUsername.setText(userDto.getUsername());
            textfildCnumber.setText(userDto.getContact_number());
            txtEmailAdressId.setText(userDto.getEmail());
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
            clearmethod();

        }

    }

    public void btnResetOnAction(ActionEvent actionEvent) {

        clearmethod();

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = lblUserId.getText();
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        UserDto dto1 = new UserDto();
        dto1.setUserid(id);

        Boolean rsp = userManegementBO.isuserAvelable(dto1);

        if (rsp) {
            boolean rsp1 = userManegementBO.deleteMethod(dto1);
            if (rsp1 == true) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Delete  Sucsssesfully");
                alert.showAndWait();
                alert.close();
                lodeTable();
                clearmethod();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Delete  Failed !");
                alert.showAndWait();
                alert.close();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User Note found");
            alert.showAndWait();
            alert.close();


        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        String Userid = lblUserId.getText();
        String password = textfildPassword.getText();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (password==null || password.isEmpty()){
            hashedPassword=null;
        }

        String pone = textfildCnumber.getText();
        String email = txtEmailAdressId.getText();
        String username = textfildUsername.getText();
        String userroll = textfildUserRolle.getText();

        UserDto dto = new UserDto(Userid, hashedPassword, pone, email, username, userroll);


        userManegementBO.updatdMethod(dto);
        lodeTable();
        clearmethod();


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        String Userid = lblUserId.getText();
        String password = textfildPassword.getText();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String pone = textfildCnumber.getText();
        System.out.println(pone);
        String email = txtEmailAdressId.getText();
        String username = textfildUsername.getText();
        String userroll = textfildUserRolle.getText();

        UserDto dto = new UserDto(Userid, hashedPassword, pone, email, username, userroll);

        System.out.println(dto.getContact_number());

        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = pone.matches(phonePattern);
        boolean rsp[] = new boolean[1];
        if (isValidEmail && isValidPhone) {

            rsp[0] = true;

        }

        if (rsp[0]) {
            String[] names = userManegementBO.saveMethod(dto);
            UserDto dto1 = userManegementBO.getlastId();
            lblUserId.setText(dto1.getUserid());
            lodeTable();
            clearmethod();

            boolean hasDuplicate = false;


            for (String name : names) {
                if (name != null) {
                    hasDuplicate = true;

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Available duplicate data, try to input unic data ");
                    alert.show();
                    break;
                }
            }

            textfildUsername.setStyle("-fx-border-color: #0046FF; -fx-border-width: 0 0 2 0 ;");
            textfildPassword.setStyle("-fx-border-color: #0046FF; -fx-border-width: 0 0 2 0 ;");
            txtEmailAdressId.setStyle("-fx-border-color: #0046FF; -fx-border-width: 0 0 2 0 ;");
            textfildCnumber.setStyle("-fx-border-color: #0046FF; -fx-border-width: 0 0 2 0 ;");

            if ("Username".equals(names[0])) {
                textfildUsername.setStyle("-fx-border-color: red;");
            }
            if ("Password".equals(names[1])) {
                textfildPassword.setStyle("-fx-border-color: red;");
            }
            if ("Email".equals(names[2])) {
                txtEmailAdressId.setStyle("-fx-border-color: red;");
            }
            if ("ContactNumber".equals(names[3])) {
                textfildCnumber.setStyle("-fx-border-color: red;");
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(" Check Your Contact number or Email To enter the correct values ");
            alert.show();

        }

    }
    public  void clearmethod(){
        textfildUserRolle.setText("");
        textfildPassword.setText("");
        textfildUsername.setText("");
        textfildCnumber.setText("");
        txtEmailAdressId.setText("");
        UserDto dto = userManegementBO.getlastId();
        lblUserId.setText(dto.getUserid());
    }

    public void lodeTable() {
        ObservableList<UserDto> cach = FXCollections.observableArrayList(userManegementBO.getUserManegementList());
        colUserID.setCellValueFactory(new PropertyValueFactory<>("Userid"));
//        colUserPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colCnumber.setCellValueFactory(new PropertyValueFactory<>("contact_number"));
        coluserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colUserRollId.setCellValueFactory(new PropertyValueFactory<>("userroll"));
        tableViewId.setItems(cach);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lodeTable();
        UserDto dto = userManegementBO.getlastId();
        lblUserId.setText(dto.getUserid());
    }
}
