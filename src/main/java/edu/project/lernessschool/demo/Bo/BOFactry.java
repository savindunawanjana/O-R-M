package edu.project.lernessschool.demo.Bo;

import edu.project.lernessschool.demo.Bo.Custom.impl.*;
//import edu.project.lernessschool.demo.Bo.Custom.impl.UserPageBOimpl;

public class BOFactry {
    private  static   BOFactry boFactry;


private   BOFactry() {

}

    public static BOFactry getInstance() {
        return boFactry == null ? (boFactry = new BOFactry()) : boFactry;
    }

    @SuppressWarnings("unchecked")
    public <Hello extends SuperBO> Hello getBO(BOtypes boType) {
        return switch (boType) {
            case LOGIN -> (Hello) new LoginPageBOImpl();

            case UserManegement -> (Hello) new UserManegementBOImpl();

            case INSTRUCTOR -> (Hello) new InstructorBOImpl();

            case STUDENTREGISTEION->(Hello) new StudentRegisterBOImpl();
            case COURSE -> (Hello) new CourseBOImpl();
        };
    }

}
