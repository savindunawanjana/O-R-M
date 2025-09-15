package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dao.SuperDAO;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Dto.UserDto;

import java.io.Serializable;
import java.util.List;

public interface InstructorBO extends SuperBO {

    boolean saveMethod(InstructorDto dto);

    boolean updatdMethod(InstructorDto dto);

    boolean deleteMethod(InstructorDto dto);

    InstructorDto getlastId();

    List<InstructorDto> getInstroctorList();

    boolean isInstroctorAvelable(InstructorDto dto);

}
