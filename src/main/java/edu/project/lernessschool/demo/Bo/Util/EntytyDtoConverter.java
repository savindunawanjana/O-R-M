package edu.project.lernessschool.demo.Bo.Util;

import edu.project.lernessschool.demo.Dto.*;
import edu.project.lernessschool.demo.Entyty.*;

import java.util.ArrayList;
import java.util.List;

public class EntytyDtoConverter {
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

}
