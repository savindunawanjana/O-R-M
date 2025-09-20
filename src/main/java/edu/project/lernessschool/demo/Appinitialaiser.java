package edu.project.lernessschool.demo;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.StudentEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Appinitialaiser  extends Application {

    public static void main(String[] args) {
        launch(args);



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


//                String id ="2003";
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
//
//        boolean match = BCrypt.checkpw(candidate, hash);
//        System.out.println("Does '2003' match the hash? " + match);



//        Session session = FactoryConfigaretion.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//        StudentEntyty studentEntyty = new StudentEntyty();
//        studentEntyty.setStudentId("S001");
//        studentEntyty.setName("savindu");
//        studentEntyty.setPnumber("0721345675");
//        studentEntyty.setEmail("savindunawanjana08@gmail.com");
//        studentEntyty.setCourse("Driving Lision");
//        studentEntyty.setFirstPayment(1000.0);
//        studentEntyty.setRegistrationDate(new Date(System.currentTimeMillis()));
//
//        EnrollmentEntyty enrollmentEntyty1 = new EnrollmentEntyty();
//        enrollmentEntyty1.setEnrollmentDate(new Date(System.currentTimeMillis()));
//        enrollmentEntyty1.setStatus("Active");
//        enrollmentEntyty1.setStudent(studentEntyty);
//
//        EnrollmentEntyty enrollmentEntyty2 = new EnrollmentEntyty();
//        enrollmentEntyty2.setEnrollmentDate(new Date(System.currentTimeMillis()));
//        enrollmentEntyty2.setStatus("Active");
//        enrollmentEntyty2.setStudent(studentEntyty);
//
//        List<EnrollmentEntyty> enrollmentEnties = new ArrayList<>();
//        enrollmentEnties.add(enrollmentEntyty2);
//        enrollmentEnties.add(enrollmentEntyty1);
//
//        studentEntyty.setEnrollments(enrollmentEnties);
//
//
//        session.persist(studentEntyty);
//transaction.commit();


    }



}
