package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.UserDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserEntyty IsAvelablePasswordForUsername(UserEntyty entyty) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        UserEntyty user = null;

        try {
            transaction = session.beginTransaction();

            user = session.createQuery(
                            "from UserEntyty where password = :upassword", UserEntyty.class)
                    .setParameter("upassword", entyty.getPassword())
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;

    }
}
