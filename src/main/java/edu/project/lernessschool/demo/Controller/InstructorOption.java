package edu.project.lernessschool.demo.Controller;

import edu.project.lernessschool.demo.Dto.InstructorDto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class InstructorOption {

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

    public void btnResetOnAction(ActionEvent actionEvent) {
        textfildName.setText("");
        textfildEmail.setText("");
        textfildSpesiality.setText("");
        textfildCnumber.setText("");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {


    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

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
                InstructorDto dto = new InstructorDto(
                        id,
                        name,
                        email,
                        Spesiality,
                        ContactNumber
                );



            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Invalid Email or Phone Number please cheak again");
                alert.show();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("please enter  Data for all text fild");
            alert.show();

        }


    }

    public void tableOnmousClicked(MouseEvent mouseEvent) {

    }
}
