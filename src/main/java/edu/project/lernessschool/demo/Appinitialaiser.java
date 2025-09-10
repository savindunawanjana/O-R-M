package edu.project.lernessschool.demo;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public class Appinitialaiser  extends Application {

    public static void main(String[] args) {
        launch(args);

//        exsamplemethod();

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();


        exsamplemethod();

    }

    public  static  void exsamplemethod(){

//
//        Session session = FactoryConfigaretion.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        UserEntyty user = new UserEntyty(
//
//                "Savindu",
//                "123",
//                "Admin",
//                0712323223,   // phone number as String
//                "savindu@gmail.com"
//        );
//
//        session.persist(user);
//        transaction.commit();
//        session.close();


    }



}
