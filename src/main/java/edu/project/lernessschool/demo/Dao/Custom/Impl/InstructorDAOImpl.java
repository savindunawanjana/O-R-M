package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Dao.Custom.InstructorDAO;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;

import java.util.List;

public class InstructorDAOImpl implements InstructorDAO {
    @Override
    public List<InstructorEntyty> getAll() throws Exception {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return null;
    }

    @Override
    public Boolean update(InstructorEntyty instructorEntyty) throws Exception {
        return null;
    }

    @Override
    public Boolean save(InstructorEntyty instructorEntyty) throws Exception {
        return null;
    }

    @Override
    public String getNextId() throws Exception {
        return "";
    }

    @Override
    public String findNameById(String Id) throws Exception {
        return "";
    }
}
