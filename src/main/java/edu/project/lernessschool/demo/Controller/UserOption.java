package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.UserManegementBO;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.mindrot.jbcrypt.BCrypt;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserOption  implements Initializable {
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^\\d{10}$"; // Only allows 10 digit numbers

    public TableView tableViewId;

    public TableColumn colUserID;
    public TableColumn colUserRollId;
    public TableColumn colUsername;
    public TableColumn colCnumber;
    public TableColumn colUserPassword;

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
    public TableColumn coluserEmail;

    private UserManegementBO  userManegementBO = BOFactry.getInstance().getBO(BOtypes.UserManegement);
    public void tblemouseClickedEvent(MouseEvent mouseEvent) {


    }

    public void btnResetOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

public void btnSaveOnAction(ActionEvent actionEvent) {

    String Userid = lblUserId.getText();
    String password = textfildPassword.getText();
    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

//    int contact_number = Integer.parseInt(textfildCnumber.getText());
    String pone = textfildCnumber.getText();
    System.out.println(pone);
    String email = txtEmailAdressId.getText();
    String username = textfildUsername.getText();
    String userroll = textfildUserRolle.getText();

    UserDto dto = new UserDto(Userid, hashedPassword, pone, email, username, userroll);

    System.out.println(dto.getContact_number());

   boolean isValidEmail = email.matches(emailPattern);
    boolean isValidPhone = pone.matches(phonePattern);
boolean  rsp []=new boolean[1];
if(isValidEmail && isValidPhone){

    rsp[0]=true;

}

    if (rsp[0]) {
    String[] names = userManegementBO.saveMethod(dto);
    UserDto dto1 = userManegementBO.getlastId();
    lblUserId.setText(dto1.getUserid());

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

}else {
        Alert alert = new  Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(" Check Your Contact number or Email To enter the correct values ");
        alert.show();

    }

}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          UserDto dto =userManegementBO.getlastId();
        lblUserId.setText(dto.getUserid());
    }
}
