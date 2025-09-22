package edu.project.lernessschool.demo.Bo.Util;

import edu.project.lernessschool.demo.Dao.Custom.CourseDAO;
import edu.project.lernessschool.demo.Dao.Custom.InstructorDAO;
import edu.project.lernessschool.demo.Dao.Custom.StudentRegistationDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.*;
import edu.project.lernessschool.demo.Entyty.*;

import java.util.ArrayList;
import java.util.List;

public class EntytyDtoConverter {
    private InstructorDAO instructorDAO = DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTOR);
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private StudentRegistationDAO studentRegistationDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENTREGISTATION);


    public UserEntyty getUserEnty(UserDto dto) {

        UserEntyty userEnty = new UserEntyty(
                dto.getUserid(),
                dto.getUsername(),
                dto.getPassword(),
                dto.getUserroll(),
                dto.getContact_number(),
                dto.getEmail()
        );

        return userEnty;


    }

    public UserDto getUserDto(UserEntyty dto) {

        UserDto user = new UserDto(
                dto.getUserid(),
                dto.getPassword(),
                dto.getContact_number(),
                dto.getEmail(),
                dto.getUsername(),
                dto.getUserroll()


        );

        return user;


    }

//    ==============================

    public InstructorEntyty getInstroctorEntyty(InstructorDto dto) {

        InstructorEntyty instroctor = new InstructorEntyty(
                dto.getInstructorId(),
                dto.getInstructorName(),
                dto.getInstructorEmail(),
                dto.getInstructorSpeciality(),
                dto.getInstructorPhone()
        );

        return instroctor;


    }

    public InstructorDto getInstroctorDto(InstructorEntyty entyty) {

        InstructorDto innstroctorDto = new InstructorDto(
                entyty.getInstructorId(),
                entyty.getInstructorName(),
                entyty.getInstructorEmail(),
                entyty.getInstructorSpeciality(),
                entyty.getInstructorPhone()
        );

        return innstroctorDto;
    }

//    ===================================================

    public StudentEntyty getStudentEntyty(Student dto) {

        StudentEntyty studentEntyty = new StudentEntyty();
        studentEntyty.setStudentId(dto.getStudentId());
        studentEntyty.setName(dto.getName());
        studentEntyty.setPnumber(dto.getPnumber());
        studentEntyty.setEmail(dto.getEmail());
//        studentEntyty.setCourse(dto.getCourse());
        studentEntyty.setRegistrationDate(dto.getRegistrationDate());
        List<EnrollmentEntyty> enrollments = new ArrayList<>();

        for (Enrolment enrolment : dto.getEnrolments()) {


            EnrollmentEntyty entyty = new EnrollmentEntyty();
            entyty.setEnrollmentDate(enrolment.getEnrollmentDate());
            entyty.setFirstPayment(enrolment.getFirstPayment());

            CourseEntyty course = new CourseEntyty();
            CourseEntyty courseEntyty = getCourseEntyty(enrolment.getCoursedto());
//            course.setCoureName(enrolment.getCourseName());
            entyty.setCourse(courseEntyty);
            enrolment.setStatus(enrolment.getStatus());
            enrollments.add(entyty);
        }

        studentEntyty.setEnrollments(enrollments);
        return studentEntyty;


    }

//    public Student getStudentDto(StudentEntyty entyty) {

//        InstructorDto innstroctorDto = new InstructorDto(
//                entyty.getInstructorId(),
//                entyty.getInstructorName(),
//                entyty.getInstructorEmail(),
//                entyty.getInstructorSpeciality(),
//                entyty.getInstructorPhone()
//        );
//
//      return null;
//    }

//    =========================================================================


    public CourseEntyty getCourseEntyty(Course dto) {
        CourseEntyty courseEntyty = new CourseEntyty();
        courseEntyty.setCourseId(dto.getCourseId());
        courseEntyty.setCoureName(dto.getCoureName());
        courseEntyty.setCourseFee(dto.getCourseFee());
        courseEntyty.setDuretion(dto.getDuretion());
        return courseEntyty;
    }


    public Course getCourseDto(CourseEntyty entyty) {
        Course coursedto = new Course();
        coursedto.setCourseId(entyty.getCourseId());
        coursedto.setCoureName(entyty.getCoureName());
        coursedto.setCourseFee(entyty.getCourseFee());
        coursedto.setDuretion(entyty.getDuretion());
        return coursedto;
    }

//    ===================================================================


    public Enrolment getEnrolmentDto(EnrollmentEntyty entyty) {

        Enrolment enrolment = new Enrolment();

        enrolment.setEnrollmentDate(entyty.getEnrollmentDate());
        enrolment.setFirstPayment(entyty.getFirstPayment());
        enrolment.setStatus(entyty.getStatus());

        EntytyDtoConverter enttyDtoConverter = new EntytyDtoConverter();
        Course course = enttyDtoConverter.getCourseDto(entyty.getCourse());
        enrolment.setCoursedto(course);

        return enrolment;
    }


//    ===================================================================

    public LessionsDto getLessionDto(LessionsEntyty entyty) {

        LessionsDto lessionDto = new LessionsDto();
        lessionDto.setInstructorId(entyty.getInstructor().getInstructorId());
        lessionDto.setCourseId(entyty.getCourse().getCourseId());
        lessionDto.setStudentId(entyty.getStudent().getStudentId());
        lessionDto.setStatus(entyty.getStatus());
        lessionDto.setTime(entyty.getTime());
        lessionDto.setDate(entyty.getDate());


        return lessionDto;
    }


    public LessionsEntyty getLessionEntyty(LessionsDto dto) {

        LessionsEntyty lessionsEntyty = new LessionsEntyty();
//        InstructorEntyty instructorEntyty = null;
//        CourseEntyty courseEntyty = null;
//        StudentEntyty studentEntyty = null;

        try {
//            instructorEntyty = instructorDAO.getInstructorEntyById(dto.getInstructorId());
//            courseEntyty = courseDAO.getCoursEntytyById(dto.getCourseId());
//            studentEntyty = studentRegistationDAO.getStudentEntytyById(dto.getStudentId());

            lessionsEntyty.setInstructor(instructorDAO.getInstructorEntyById(dto.getInstructorId()));
            lessionsEntyty.setCourse(courseDAO.getCoursEntytyById(dto.getCourseId()));
            lessionsEntyty.setStudent(studentRegistationDAO.getStudentEntytyById(dto.getStudentId()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        lessionsEntyty.setStatus(dto.getStatus());
        lessionsEntyty.setTime(dto.getTime());
        lessionsEntyty.setDate(dto.getDate());


        return lessionsEntyty;
    }


}
