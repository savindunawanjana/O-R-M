package edu.project.lernessschool.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LessionsDto {

    private String instructorId;
    private String courseId;
    private String studentId;
    private String status;
    private String time;
    private String Date;

}
