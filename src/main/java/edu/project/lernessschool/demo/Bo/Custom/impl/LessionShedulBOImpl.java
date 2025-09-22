package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.BOFactry;
import edu.project.lernessschool.demo.Bo.BOtypes;
import edu.project.lernessschool.demo.Bo.Custom.InstructorBO;
import edu.project.lernessschool.demo.Bo.Custom.LessionShedulBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.InstructorDAO;
import edu.project.lernessschool.demo.Dao.Custom.LessionShedulDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.LessionsDto;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;
import edu.project.lernessschool.demo.Entyty.LessionsEntyty;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class LessionShedulBOImpl implements LessionShedulBO {
    private LessionShedulDAO lessionShedulDAO = DAOFactory.getInstance().getDAO(DAOTypes.LESSIONS);
    private InstructorDAO instructorDAO = DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTOR);


    @Override
    public String getStudentIdNumber(List<String> nameAndPonenumber) {
        try {
            String studentId = lessionShedulDAO.getStudentIdNumber(nameAndPonenumber);
            if (studentId == null) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Student ID Not Found");
                alert.showAndWait();


            }
            return studentId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Enrolment> getallCoursesForStudent(String studentId) {
        try {

            List<EnrollmentEntyty> entyty = lessionShedulDAO.getallCoursesForStudent(studentId);
            List<Enrolment> enrolments = new ArrayList<>();
            EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();

            for (EnrollmentEntyty e : entyty) {
                Enrolment dto = enttyDtoConverter.getEnrolmentDto(e);
                System.out.println(dto.getCoursedto().getCourseId());
                enrolments.add(dto);
            }
            return enrolments;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<InstructorDto> getallInstroctors() {

        try {

            List<InstructorDto> instructors = new ArrayList<>();
            List<InstructorEntyty> instructorEntytyList = instructorDAO.getAll();

            EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();

            for (InstructorEntyty instructorEntyty : instructorEntytyList) {

                InstructorDto instructorDto = enttyDtoConverter.getInstroctorDto(instructorEntyty);
                instructors.add(instructorDto);

            }

            if(instructors==null){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Sorry  No Instructors in the System yet !");
                alert.show();

            }  return instructors ;



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean savemethod(LessionsDto dto) {

        EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();
      LessionsEntyty lessionsEntyty= enttyDtoConverter.getLessionEntyty(dto);

      try {
         boolean rsp =lessionShedulDAO.savemethod(lessionsEntyty) ;
          System.out.println("======7=====");
          System.out.println(rsp);
          System.out.println("====================7===");
         return rsp;

      }catch (Exception e){
          e.printStackTrace();
          return false;
      }




    }

    @Override
    public List<LessionsDto> getReleventLessionObjects(String courseId, String date, String time, String instroctorId) {

        List<LessionsDto> lessionsDtoList = new ArrayList<>();
        try{
            java.util.List<LessionsEntyty>lessionsEntyties =lessionShedulDAO.getReleventLessionObjects(courseId,date,time,instroctorId);

            for(LessionsEntyty e : lessionsEntyties){
                EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();
                LessionsDto dto = enttyDtoConverter.getLessionDto(e);
                lessionsDtoList.add(dto);
            }
            return lessionsDtoList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }


    }



}
