package edu.project.lernessschool.demo.Entyty;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntyty {

@Id
    private String studentId;

private String name;

private String pnumber;

private String email;

//private String Course;

//private Double firstPayment;

private Date registrationDate;

@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<EnrollmentEntyty> enrollments;


    @OneToMany(mappedBy = "student")
    private List<LessionsEntyty> lessionslist;
//    student
    @OneToMany(mappedBy = "student")
    private List<PaymentEntyty> paymentEnties;

}
