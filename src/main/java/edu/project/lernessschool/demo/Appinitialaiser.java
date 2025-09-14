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
import org.mindrot.jbcrypt.BCrypt;

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
//        $2a$10$OJ0NsuQ0pVIfC.QHzJ1re.sIJWz7PcG8X1hSPs04jQHROUo6U/oF6
//        String hash = "$2a$10$OJ0NsuQ0pVIfC.QHzJ1re.sIJWz7PcG8X1hSPs04jQHROUo6U/oF6";
//        System.out.println("chek=====================");
//        System.out.println(BCrypt.checkpw("123", hash)); // true or false?
//        System.out.println("chek=====================");

        exsamplemethod();

    }

    public  static  void exsamplemethod(){

//        String id ="2003";
//        String hashedPassword = BCrypt.hashpw(id, BCrypt.gensalt());
//
//        Session session = FactoryConfigaretion.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        UserEntyty user = new UserEntyty(
//                "U001",
//                "savindu",
//                hashedPassword,
//                "Admin",
//                "0724659887",   // phone number as String
//                "nawanjana@gmail.com"
//        );
//
//        session.persist(user);
//        transaction.commit();
//        session.close();
//        String hash = "$2a$10$Qg8NmSC7nB.qQlyHBH0s9.t9GpKVomVAfB2LhVF0AY4b/xda0SZ8W";
//        String candidate = "2003";

//        boolean match = BCrypt.checkpw(candidate, hash);
//        System.out.println("Does '2003' match the hash? " + match);

    }



}
