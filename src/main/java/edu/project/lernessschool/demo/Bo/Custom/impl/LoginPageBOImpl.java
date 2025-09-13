package edu.project.lernessschool.demo.Bo.Custom.impl;

import edu.project.lernessschool.demo.Bo.Custom.LoginPageBO;
//import edu.project.lernessschool.demo.Bo.Custom.UserPageBO;
import edu.project.lernessschool.demo.Dao.Custom.UserDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.LoinDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.scene.control.Alert;
//UserPageBOimpl
public class LoginPageBOImpl  implements LoginPageBO {
    private final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);
    @Override
    public Boolean IsAvelablePasswordForUsername(LoinDto dto) {


        try {
            UserEntyty usrEntyty = new UserEntyty();
            usrEntyty.setUsername(dto.getUsername());
            usrEntyty.setPassword(dto.getPassword());

            UserEntyty  userEntyty = userDAO.IsAvelablePasswordForUsername(usrEntyty);

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


}
