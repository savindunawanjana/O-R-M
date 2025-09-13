module edu.project.lernessschool.demo {
    // JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Standard Java modules
    requires java.sql;
    requires java.desktop;

    // Database connector
    requires mysql.connector.j;

    // JPA / Hibernate
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    requires java.naming;
    requires jbcrypt;
//    requires edu.project.lernessschool.demo;
//    requires edu.project.lernessschool.demo;


//    requires org.mindrot.jbcrypt;// BCrypt module

    // Opens packages for reflection
    opens edu.project.lernessschool.demo.Entyty to org.hibernate.orm.core; // Hibernate access
    opens edu.project.lernessschool.demo.Controller to javafx.fxml;       // JavaFX controllers
    opens edu.project.lernessschool.demo to javafx.fxml, javafx.graphics; // optional if needed
    opens edu.project.lernessschool.demo.Entyty.compositeKey to org.hibernate.orm.core;

    // Export main package
    exports edu.project.lernessschool.demo;
}
