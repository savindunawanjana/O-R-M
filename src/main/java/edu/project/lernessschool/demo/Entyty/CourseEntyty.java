package edu.project.lernessschool.demo.Entyty;

import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Course")
public class CourseEntyty {

    @Id
  private String courseId;

  private String coureName;
  private double CourseFee;
  private  String  duretion;

  @OneToMany(mappedBy = "course")
  private List<EnrollmentEntyty> enrollmentEntytys;

    @OneToMany(mappedBy = "course")
    private List<LessionsEntyty> lessionslist;



}

