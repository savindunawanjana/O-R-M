package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dao.CrudDAO;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;

public interface CourseDAO extends CrudDAO<CourseEntyty> {
    CourseEntyty getLastId();

    CourseEntyty getCoursEntytyById(String id);

}