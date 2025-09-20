package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.CourseBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.CourseDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.Course;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);

    @Override
    public Boolean saveMethod(Course dto) {
       try  {
           EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
         CourseEntyty courseEntyty = entytyDtoConverter.getCourseEntyty(dto);
       boolean rsp   = courseDAO.save(courseEntyty);
         return  rsp;

       }catch(Exception ex){
           ex.printStackTrace();
           return false;
       }
    }

    @Override
    public Boolean updatdMethod(Course dto) {
        try  {
            EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
            CourseEntyty courseEntyty = entytyDtoConverter.getCourseEntyty(dto);
            boolean rsp   = courseDAO.update(courseEntyty);
            return  rsp;

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteMethod(Course dto) {
        try  {
            EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
            CourseEntyty courseEntyty = entytyDtoConverter.getCourseEntyty(dto);
            String id = courseEntyty.getCourseId();
            boolean rsp   = courseDAO.delete(id);
            return  rsp;

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public String getlastId() {

        try {
            CourseEntyty entyty= courseDAO.getLastId();

            char prefix = 'C';
            if (entyty == null) {
                System.out.println("me thiyenne ee thana");
                return "C001";
            } else {
                String id = entyty.getCourseId();

                String numberPart = id.substring(1);
                int lastIdNumber = Integer.parseInt(numberPart);
                int nextIdNumber = lastIdNumber + 1;
                String newId = String.format(prefix + "%03d", nextIdNumber);
                return newId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Course> getCourseList() {

        System.out.println("ou meka  getCourseList methode eka");
        List<Course> courseList = new ArrayList<>();
        try {

            List<CourseEntyty> courseEntyties = courseDAO.getAll();
            for (CourseEntyty entyty : courseEntyties) {
                System.out.println(entyty);
                EntytyDtoConverter entytyDtoConverter = new EntytyDtoConverter();
                Course dto = entytyDtoConverter.getCourseDto(entyty);
                courseList.add(dto);
            }
            if(courseList.isEmpty()|| courseList==null){
                System.out.println("ou meka null wenawa ");

            }

            return courseList;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }
}
