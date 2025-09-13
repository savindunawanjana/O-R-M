package edu.project.lernessschool.demo.Dao;

//import edu.project.lernessschool.demo.Bo.Custom.impl.UserPageBOimpl;
import edu.project.lernessschool.demo.Dao.Custom.Impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    @SuppressWarnings("unchecked")
    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        return switch (daoType) {
            case USER -> (T) new UserDAOImpl();

        };
    }

}
