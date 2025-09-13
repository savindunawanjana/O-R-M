package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;

import java.lang.reflect.Array;
import java.util.List;

public interface UserManegementBO  extends SuperBO {


    String[] saveMethod(UserDto dto);
    void updatdMethod(UserDto dto);
    void deleteMethod(UserDto dto);
    UserDto getlastId();
    List<UserDto> getUserManegementList();






}
