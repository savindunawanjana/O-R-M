package edu.project.lernessschool.demo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Dashbord {

    public Button btnUser;
    public Button btnCourse;
    public Button btnCustormer;
    public Button btnLessonScheduling;
    public Button btnInstructor;
    public Button btnPayment;
    public Button btnLogout;
    //public AnchorPane mainContentPane;
    public Label lblTitle;
    public TextField txtUsername;
    public Label lblTime;
    public PasswordField txtPassword;
    public Button btnSubmitLogin;
    public AnchorPane SubContentPane;
    public AnchorPane rootPane;

    public void onActionUserbutten(ActionEvent actionEvent) {

        navigate("/View/User.fxml");

    }

    public void onActionCoursebutten(ActionEvent actionEvent) {
        navigate("/View/Course.fxml");
    }

    public void onActionCusternbutten(ActionEvent actionEvent) {
        navigate("/View/Custormer.fxml");

    }

    public void onActionLessonSchedulingButten(ActionEvent actionEvent) {

        navigate("/View/LessionShedul.fxml");

    }

    public void onActionInstructorbtn(ActionEvent actionEvent) {
        navigate("/View/Instructor.fxml");

    }

    public void onactionPaymentbtn(ActionEvent actionEvent) {
        //        navigetion();

    }

    public void onactionLogout(ActionEvent actionEvent) throws IOException {

        rootPane.getChildren().clear();

        // Load as Parent to avoid class cast issues
        Parent view = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));

        // Let the loaded view fill the AnchorPane
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);

        rootPane.getChildren().add(view);

    }

    public void onSubmitLoginClick(ActionEvent actionEvent) {
        //        navigetion();

    }

    public  void navigate(String Path) {

        try {
            SubContentPane.getChildren().clear();

            // Load as Parent to avoid class cast issues
            Parent view = FXMLLoader.load(getClass().getResource(Path));

            // Let the loaded view fill the AnchorPane
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            SubContentPane.getChildren().add(view);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
            e.printStackTrace();
        }






    }
}
