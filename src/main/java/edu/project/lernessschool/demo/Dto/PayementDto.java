package edu.project.lernessschool.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayementDto {

private String courseId;
private String studentId;
private Double payementfee;

}
