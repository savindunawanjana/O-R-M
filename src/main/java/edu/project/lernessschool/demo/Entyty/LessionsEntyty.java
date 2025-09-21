package edu.project.lernessschool.demo.Entyty;

import jakarta.persistence.*;

@Entity
@Table(name = "Lession")
public class LessionsEntyty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @ManyToOne()
    private InstructorEntyty instructor;

    @ManyToOne
    private CourseEntyty course;

    @ManyToOne
    private StudentEntyty student;

    private String status;

    private String time;

    private String Date;


}
