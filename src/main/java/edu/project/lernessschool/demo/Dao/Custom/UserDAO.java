package edu.project.lernessschool.demo.Dao.Custom;

import edu.project.lernessschool.demo.Dao.SuperDAO;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

import java.util.List;

public interface UserDAO extends SuperDAO {


     UserEntyty IsAvelablePasswordForUsername(UserEntyty entyty)throws Exception;;

    Boolean saveMethod(UserEntyty entyty)throws Exception;
    Boolean updatdMethod(UserEntyty entyty)throws Exception;
    Boolean deleteMethod(UserEntyty entyty)throws Exception;
    boolean  isAvelabledublicateUsername(UserEntyty entyty)throws Exception;
    boolean  isAvelabledublicatePassword(UserEntyty entyty)throws Exception;
    boolean  isAvelabledublicateEmail(UserEntyty entyty)throws Exception;
    UserEntyty getLastId()throws Exception;
    boolean  isAvelabledublicateContactNumber(UserEntyty entyty)throws Exception;

    List<UserDto> getUserManegementList()throws Exception;




}
