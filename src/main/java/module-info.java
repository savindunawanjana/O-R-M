module edu.project.lernessschool.demo {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires javafx.graphics;
//    requires java.sql;
//
//
//    opens edu.project.lernessschool.demo to javafx.fxml;
//    exports edu.project.lernessschool.demo;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
//    requires static lombok;
    requires jdk.compiler;
    requires java.desktop;
    requires javafx.graphics;
//    requires java.mail;
//    requires net.sf.jasperreports.core;
//    requires batik.anim;
//edu.lk.ijse.projectgym.demo76promax.Dtos
    opens edu.project.lernessschool.demo.Entyty to javafx.base;//table eke data pennuwe na meka danakam
    opens edu.project.lernessschool.demo.Controller to javafx.fxml;
    opens edu.project.lernessschool.demo to javafx.fxml, javafx.graphics;
    exports edu.project.lernessschool.demo;
//    opens edu.lk.ijse.projectgym.demo76promax.Dtos.tm to javafx.base;

}

