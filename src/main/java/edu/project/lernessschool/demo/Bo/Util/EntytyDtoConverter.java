package edu.project.lernessschool.demo.Bo.Util;

import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

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

}
