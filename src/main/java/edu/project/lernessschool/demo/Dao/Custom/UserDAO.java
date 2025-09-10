package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.SuperDAO;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

import java.util.List;

public interface UserDAO extends SuperDAO {


     UserEntyty IsAvelablePasswordForUsername(UserEntyty entyty);

}
