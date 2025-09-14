package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.UserDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Dao.DAOTypes;
import edu.project.lernessschool.demo.Dto.UserDto;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public UserEntyty IsAvelablePasswordForUsername(UserEntyty entyty) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        UserEntyty user = null;

        try {

            transaction = session.beginTransaction();
            List<UserEntyty> users = session.createQuery("from UserEntyty", UserEntyty.class)
                    .getResultList();
            transaction.commit();

            for (UserEntyty u : users) {

                boolean passwordMatch = BCrypt.checkpw(entyty.getPassword(), u.getPassword());
                System.out.println(passwordMatch);
                if (passwordMatch) {
                    if (u.getUsername().equals(entyty.getUsername())) {
                        System.out.println("user Entyty =" + u);
                        return u;

                    }
                }

            }


        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println(" exseption ekak ena thanin riturn wenne null");
            return null;
        } finally {
            session.close();
        }

        System.out.println("riturn wenne null");
        return null;

    }

    @Override
    public Boolean saveMethod(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.persist(new UserEntyty(
                    entyty.getUserid(),
                    entyty.getUsername(),
                    entyty.getPassword(),
                    entyty.getUserroll(),
                    entyty.getContact_number(),
                    entyty.getEmail()
            ));

            transaction.commit();
            return true;
        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public Boolean updatdMethod(UserEntyty entyty) throws Exception {
        System.out.println("updete methode eka dao keke");

        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(entyty.getPassword());

        System.out.println(entyty.getPassword() == null || entyty.getPassword().isEmpty());
        if (entyty.getPassword() == null || entyty.getPassword().isEmpty()) {
            try {
                UserEntyty userEntyty = session.createQuery(
                                "from UserEntyty where Userid = :userid", UserEntyty.class)
                        .setParameter("userid", entyty.getUserid())
                        .uniqueResult();
                System.out.println("=====================================");
                if (userEntyty != null) {
                    System.out.println(userEntyty.getUsername());
                    entyty.setPassword(userEntyty.getPassword());
                    System.out.println(entyty);
                }
                System.out.println("=====================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            session.merge(entyty); // use entyty directly instead of new UserEntyty(...)
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Boolean deleteMethod(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // DB එකෙන් ගන්න user එක
            UserEntyty user = session.get(UserEntyty.class, entyty.getUserid());

            if (user != null) {
                session.delete(user);   // record එක delete වෙනවා
                transaction.commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean isAvelabledublicateUsername(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();

        boolean rsp[] = new boolean[1];
        try {

            UserEntyty userEntyty = session.createQuery(
                            "from UserEntyty where username = :username", UserEntyty.class)
                    .setParameter("username", entyty.getUsername())
                    .uniqueResult();
            if (userEntyty == null) {
                //   System.out.println(userEntyty);
                rsp[0] = false;

            } else {
                rsp[0] = true;
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            session.close();
        }
        return rsp[0];

    }

    @Override
    public boolean isAvelabledublicatePassword(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();

        boolean rsp[] = new boolean[1];
        try {

            UserEntyty userEntyty = session.createQuery(
                            "from UserEntyty where password = :upassword", UserEntyty.class)
                    .setParameter("upassword", entyty.getPassword())
                    .uniqueResult();


            if (userEntyty == null) {
                rsp[0] = false;

            } else {
                rsp[0] = true;
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            session.close();
        }
        return rsp[0];
    }

    @Override
    public boolean isAvelabledublicateEmail(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();

        boolean rsp[] = new boolean[1];
        try {

            UserEntyty userEntyty = session.createQuery(
                            "from UserEntyty where email = :email", UserEntyty.class)
                    .setParameter("email", entyty.getEmail())
                    .uniqueResult();


            if (userEntyty == null) {
                rsp[0] = false;

            } else {
                rsp[0] = true;
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            session.close();
        }
        return rsp[0];
    }

    @Override
    public UserEntyty getLastId() throws Exception {

        Session session = FactoryConfigaretion.getInstance().getSession();

        try {

//           UserEntyty lastUser;
            return session.createQuery(
                            "FROM UserEntyty u ORDER BY u.Userid DESC",   // HQL query
                            UserEntyty.class                              // return type (entity class)
                    )
                    .setMaxResults(1)                                // eka result witharai ganna
                    .uniqueResultOptional()                          // Optional<UserEntyty> return wenawa
                    .orElse(null);                                   // result nathnam null return karanawa

//           return lastUser;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return null;

    }

    @Override
    public boolean isAvelabledublicateContactNumber(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();

        boolean rsp[] = new boolean[1];
        try {

            UserEntyty userEntyty = session.createQuery(
                            "from UserEntyty where contact_number = :contact_number", UserEntyty.class)
                    .setParameter("contact_number", entyty.getContact_number())
                    .uniqueResult();


            if (userEntyty == null) {
                rsp[0] = false;

            } else {
                rsp[0] = true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            session.close();
        }
        return rsp[0];
    }

    @Override
    public boolean isuserAvelable(UserEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        UserEntyty userEntyty = session.createQuery("from UserEntyty where  Userid= :userid", UserEntyty.class)
                .setParameter("userid", entyty.getUserid())
                .uniqueResult();

        transaction.commit();

        if (userEntyty != null) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public List<UserEntyty> getUserManegementList() throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        List<UserEntyty> userList = new ArrayList<>();

        try {
            transaction = session.beginTransaction();

            userList = session.createQuery("from UserEntyty", UserEntyty.class)
                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

        return userList;
    }


}
