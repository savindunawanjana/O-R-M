package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.LoginPageBO;
//import edu.project.lernessschool.demo.Bo.Custom.UserPageBO;
import edu.project.lernessschool.demo.Dao.Custom.UserDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.LoginDto;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.scene.control.Alert;
//UserPageBOimpl
public class LoginPageBOImpl  implements LoginPageBO {
    private UserDto dto2;
    private final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);
    @Override
    public Boolean IsAvelablePasswordForUsername(LoginDto dto) {


        try {
            UserEntyty usrEntyty = new UserEntyty();
            usrEntyty.setUsername(dto.getUsername());
            usrEntyty.setPassword(dto.getPassword());

            UserEntyty  userEntyty = userDAO.IsAvelablePasswordForUsername(usrEntyty);
//            dto2.setUserroll(userEntyty.getUserroll());
//            System.out.println(dto2.getUserroll());

            if(userEntyty == null &&  !(userEntyty.getUsername().equals(dto.getUsername())) ){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Authentication !");
                alert.show();
                return false;
            }else if (userEntyty == null ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("  Invalid Password ");
                alert.show();
                return false;
            }else if (!userEntyty.getUsername().equals(dto.getUsername())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("!");
                alert.setHeaderText("Error");
                alert.setContentText(" Invalid Username");
                alert.show();
                return false;
            }

            return true;

        }catch (Exception ex){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("!");
            alert.setHeaderText("Error");
            alert.setContentText(" Invalid Authentication please try again !");
            alert.show();

            return false;

        }

    }

    public  UserDto getUserrolleFromdto(){
        return dto2;
    }


}
