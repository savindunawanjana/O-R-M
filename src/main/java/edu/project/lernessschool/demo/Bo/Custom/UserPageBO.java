package edu.project.lernessschool.demo.Bo.Custom;

import edu.project.lernessschool.demo.Bo.SuperBO;
import edu.project.lernessschool.demo.Dto.LoinDto;

public interface UserPageBO extends SuperBO {

 Boolean IsAvelablePasswordForUsername( LoinDto dto);


}
