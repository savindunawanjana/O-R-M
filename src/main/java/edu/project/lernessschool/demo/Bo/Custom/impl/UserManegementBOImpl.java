package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.UserManegementBO;
import edu.project.lernessschool.demo.Bo.Util.EntytyDtoConverter;
import edu.project.lernessschool.demo.Dao.Custom.UserDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import java.util.List;


public class UserManegementBOImpl implements UserManegementBO {

    private EntytyDtoConverter   converter = new EntytyDtoConverter();
    private UserDAO userDAO= DAOFactory.getInstance().getDAO(DAOTypes.USER);


    @Override
    public String[] saveMethod(UserDto dto) {
         String[]name = new String[4];
        UserEntyty entyty =converter.getUserEnty(dto);
        boolean rsp[] =new boolean[1];
        try {
            boolean  isAvelabledublicateUsername =userDAO.isAvelabledublicateUsername(entyty);
            boolean  isAvelabledublicatePassword=userDAO.isAvelabledublicatePassword(entyty);
            boolean  isAvelabledublicateEmail=userDAO.isAvelabledublicateEmail(entyty);
            boolean  isAvelabledublicateContactNumber=userDAO.isAvelabledublicateContactNumber(entyty);

            if(isAvelabledublicateUsername==true ||isAvelabledublicatePassword==true||isAvelabledublicateEmail==true||isAvelabledublicateContactNumber==true){
                rsp[0]= true;
            }

            if (isAvelabledublicateUsername){
                name [0]="Username";
            }
            if (isAvelabledublicatePassword){
                name[1]="Password";
            }
            if (isAvelabledublicateEmail){
                name[2]="Email";
            }
            if (isAvelabledublicateContactNumber){
                name[3]="ContactNumber";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            boolean rsp1  = userDAO.saveMethod(entyty);
            System.out.println("Dao eke saveMethod ekata coll wenawa "+ "ewagema rsp = "+rsp1);

        }catch (Exception e){
e.printStackTrace();

        }
        return name;
    }

    @Override
    public void updatdMethod(UserDto dto) {
    }
    @Override
    public void deleteMethod(UserDto dto) {
    }
    @Override
    public UserDto getlastId() {
        UserDto dto3 = new UserDto();
        try{
            UserEntyty userEntyty =userDAO.getLastId();
   EntytyDtoConverter converter = new EntytyDtoConverter();
     UserDto dto =converter.getUserDto(userEntyty);
            UserDto dto2 = new  UserDto();
            char prefix = 'U';
            if(dto==null){
                dto3.setUserid("U001");
            }else {
                String id   =dto.getUserid();
                String numberPart = id.substring(1);
                int lastIdNumber = Integer.parseInt(numberPart);
                int nextIdNumber = lastIdNumber + 1;
               String newId =  String.format(prefix + "%03d", nextIdNumber);
                dto2.setUserid(newId);
                return dto2;
            }
        }catch (Exception e){e.printStackTrace();}
        return dto3;
    }

    @Override
    public List<UserDto> getUserManegementList() {
        return List.of();
    }
}
