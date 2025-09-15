package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.InstructorBO;
import edu.project.lernessschool.demo.Dto.InstructorDto;

import java.util.List;

public class InstructorBOImpl implements InstructorBO {


    @Override
    public boolean saveMethod(InstructorDto dto) {
        return false;
    }

    @Override
    public boolean updatdMethod(InstructorDto dto) {
        return false;
    }

    @Override
    public boolean deleteMethod(InstructorDto dto) {
        return false;
    }

    @Override
    public InstructorDto getlastId() {
        return null;
    }

    @Override
    public List<InstructorDto> getInstroctorList() {
        return List.of();
    }

    @Override
    public boolean isInstroctorAvelable(InstructorDto dto) {
        return false;
    }
}
