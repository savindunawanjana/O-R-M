package edu.project.lernessschool.demo.Entyty;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment")
public class EnrollmentEntyty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    private Date enrollmentDate;
    private Double firstPayment;
    private String status; // Active, Completed, Dropped

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntyty student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntyty course;

    // getters and setters
}
