package edu.project.lernessschool.demo.Dto;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrolment {
    private Date enrollmentDate;
    private Double firstPayment;
    private Button removebutton;
    private String status;
    private Course coursedto;


}
