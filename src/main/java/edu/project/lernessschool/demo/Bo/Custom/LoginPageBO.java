package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.LoginDto;
import edu.project.lernessschool.demo.Dto.UserDto;

public interface LoginPageBO extends SuperBO {

 Boolean IsAvelablePasswordForUsername( LoginDto dto);
    UserDto getUserrolleFromdto();

}
