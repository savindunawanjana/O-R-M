package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.InstructorBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.InstructorDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.InstructorDto;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class InstructorBOImpl implements InstructorBO {
    private final InstructorDAO instructorDao = DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTOR);

    @Override
    public boolean saveMethod(InstructorDto dto) {


        if (dto.getInstructorId() != null && dto.getInstructorName() != null && dto.getInstructorPhone() != null && dto.getInstructorEmail() != null && dto.getInstructorSpeciality() != null) {
            EntytyDtoConverter converter = new EntytyDtoConverter();

            InstructorEntyty entyty = converter.getInstroctorEntyty(dto);

            try {
                boolean rsp = instructorDao.save(entyty);
                return rsp;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;

            }

        } else {
            return false;

        }

    }

    @Override
    public boolean updatdMethod(InstructorDto dto) {
        EntytyDtoConverter converter = new EntytyDtoConverter();

        InstructorEntyty entyty = converter.getInstroctorEntyty(dto);
        try {
            Boolean rsp = instructorDao.update(entyty);
            return rsp;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean deleteMethod(InstructorDto dto) {
        EntytyDtoConverter converter = new EntytyDtoConverter();

        InstructorEntyty entyty = converter.getInstroctorEntyty(dto);
        try {
            String id = entyty.getInstructorId();
            Boolean rsp = instructorDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public InstructorDto getlastId() {
        try {
            String id = instructorDao.getNextId();

            char prefix = 'I';
            if (id.equals(null)||id.equals("")) {
                id = "I001";
                InstructorDto dto = new InstructorDto();
                dto.setInstructorId(id);
                return dto;
            } else {

                String numberPart = id.substring(1);
                int lastIdNumber = Integer.parseInt(numberPart);
                int nextIdNumber = lastIdNumber + 1;
                String newId = String.format(prefix + "%03d", nextIdNumber);
                InstructorDto dto = new InstructorDto();
                dto.setInstructorId(newId);
                return dto;
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<InstructorDto> getInstroctorList() {

        List<InstructorDto> dtoList = new ArrayList<>();

        try {

            List <InstructorEntyty> instructorEntytyList =instructorDao.getAll();
            for (InstructorEntyty entyty : instructorEntytyList) {

                EntytyDtoConverter converter = new EntytyDtoConverter();
            InstructorDto dto  = converter.getInstroctorDto(entyty);
            dtoList.add(dto);
            }

            return dtoList;

        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean isInstroctorAvelable(InstructorDto dto) {
        return false;
    }
}
