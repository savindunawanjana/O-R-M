package edu.project.lernessschool.demo.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {


    public TextField txtUsername;

    public Button btnLogin;
    public Button btnCancel;
    public AnchorPane AnchorpaneId;
    public PasswordField PasswordfildId;
    public Button showPasswordButten;
    public Label FrogatpasswordLableId;
    public PasswordField passwordfilId;
    public TextField textfildId;
    private boolean array[] ={true};

    public void handleLoginAction(ActionEvent actionEvent) {
        navigate("/View/Dashbord.fxml");

    }

    public void handleCancelAction(ActionEvent actionEvent) {
    }

    public void navigate(String Path) {

        try {
            AnchorpaneId.getChildren().clear();

            // Load as Parent to avoid class cast issues
            Parent view = FXMLLoader.load(getClass().getResource(Path));

            // Let the loaded view fill the AnchorPane
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            AnchorpaneId.getChildren().add(view);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            e.printStackTrace();
        }

    }

    public void showPasswordButtenONaction(ActionEvent actionEvent) {
        textfildId.setStyle(" -fx-border-width: 1;");


        if(array[0]){

            AnchorPane.setLeftAnchor(textfildId, 90.0);
            AnchorPane.setTopAnchor(textfildId, 468.0);
            passwordfilId.setVisible(false);
            textfildId.setVisible(true);
            showPasswordButten.setText("Hide Password");
            array[0]=false;
            System.out.println(array[0]);
        }else {

            passwordfilId.setVisible(true);
            textfildId.setVisible(false);
            AnchorPane.setLeftAnchor(textfildId, 88.0); // x
            AnchorPane.setTopAnchor(textfildId, 822.0);  // y
            showPasswordButten.setText("Show Password");
            array[0] = true;

        }



    }

    public void FrogatpasswordLableIdOnAction(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        showPasswordButten.setText("Show Password");
        textfildId.textProperty().bindBidirectional(passwordfilId.textProperty());
        passwordfilId.setVisible(true);
        textfildId.setVisible(false);

    }
}
