package edu.project.lernessschool.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private String studentId;
    private String name;
    private String pnumber;
    private String email;
    private String Course;
//    private Double firstPayment;
    private Date registrationDate;
    private List<Enrolment> enrolments;


}
