package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.StudentRegisterBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.CourseDAO;
import edu.project.lernessschool.demo.Dao.Custom.StudentRegistationDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.Student;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.StudentEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

import java.util.ArrayList;
import java.util.List;

public class StudentRegisterBOImpl implements StudentRegisterBO {

    private StudentRegistationDAO studentRegistationDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENTREGISTATION);
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);


    @Override
    public boolean registerStudent(Student student) {

        EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
        StudentEntyty studentEntyty = entytyDtoConverter.getStudentEntyty(student);

        try {
            boolean rsp = studentRegistationDAO.save(studentEntyty);
            return rsp;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public String getNextId() {
        UserDto dto3 = new UserDto();
        try {
            String avelableId = studentRegistationDAO.getNextId();

            char prefix = 'S';
            if (avelableId == null) {
                return "S001";
            } else {
                String id = avelableId;
                String numberPart = id.substring(1);
                int lastIdNumber = Integer.parseInt(numberPart);
                int nextIdNumber = lastIdNumber + 1;
                String newId = String.format(prefix + "%03d", nextIdNumber);
                System.out.println(newId+"=============new Id===============");
                return newId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Course> getAllCourses() {
        try {
            List<Course> courseList = new ArrayList<>();
            List<CourseEntyty> courseEntyties = courseDAO.getAll();
            EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();

            for (CourseEntyty courseEntyty : courseEntyties) {
                Course dto = entytyDtoConverter.getCourseDto(courseEntyty);
                courseList.add(dto);
            }

            return courseList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}