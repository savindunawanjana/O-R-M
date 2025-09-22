package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.CrudDAO;
import edu.project.lernessschool.demo.Dao.SuperDAO;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.StudentEntyty;

public interface StudentRegistationDAO extends CrudDAO<StudentEntyty> {

    CourseEntyty getCourseEntyByname(String name);
    StudentEntyty getStudentEntytyById(String id);
}
