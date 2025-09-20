package edu.project.lernessschool.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private String courseId;
    private String coureName;
    private double CourseFee;
    private  String  duretion;
}
