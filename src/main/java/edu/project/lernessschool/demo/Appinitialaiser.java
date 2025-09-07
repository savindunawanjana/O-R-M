package edu.project.lernessschool.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Appinitialaiser  extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();

    }

}
