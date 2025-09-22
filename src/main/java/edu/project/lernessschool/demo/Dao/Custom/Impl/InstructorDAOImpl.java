package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.InstructorDAO;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InstructorDAOImpl implements InstructorDAO {
    @Override
    public List<InstructorEntyty> getAll() throws Exception {


        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        List<InstructorEntyty> instructorEntytyList = new ArrayList<>();

        try {
            transaction = session.beginTransaction();

            instructorEntytyList = session.createQuery("from InstructorEntyty", InstructorEntyty.class)
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

        return instructorEntytyList;
    }

    @Override
    public Boolean delete(String id) throws Exception {

        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            InstructorEntyty instructorEntyty = session.get(InstructorEntyty.class,id);

            if (instructorEntyty != null) {
                session.delete(instructorEntyty);   // record එක delete වෙනවා
                transaction.commit();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean update(InstructorEntyty instructorEntyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//        System.out.println(entyty.getPassword());

//        System.out.println(entyty.getPassword() == null || entyty.getPassword().isEmpty());
        if (instructorEntyty.getInstructorId() != null && instructorEntyty.getInstructorName() != null && instructorEntyty.getInstructorPhone() != null && instructorEntyty.getInstructorEmail() != null && instructorEntyty.getInstructorSpeciality() != null) {
            try {
                InstructorEntyty instructorEntyty1 = session.createQuery(
                                "from InstructorEntyty where instructorPhone = :cnumber", InstructorEntyty.class)
                        .setParameter("cnumber", instructorEntyty.getInstructorPhone())
                        .uniqueResult();


                if (instructorEntyty1.getInstructorId().equals(instructorEntyty.getInstructorId())) {

                    try {
                        session.merge(instructorEntyty); // use entyty directly instead of new UserEntyty(...)
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


                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("the ContactNumber is Alredy Avelable. Pleas Update this with use another Number ");
                    alert.show();
                    return false;


                }


            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
//        return false;


    }

    @Override
    public Boolean save(InstructorEntyty instructorEntyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.persist(new InstructorEntyty(
                    instructorEntyty.getInstructorId(),
                    instructorEntyty.getInstructorName(),
                    instructorEntyty.getInstructorEmail(),
                    instructorEntyty.getInstructorSpeciality(),
                    instructorEntyty.getInstructorPhone()
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
    public String getNextId() throws Exception {


        Session session = FactoryConfigaretion.getInstance().getSession();

        try {

//           UserEntyty lastUser;
            InstructorEntyty entyty = session.createQuery(
                            "FROM InstructorEntyty u ORDER BY u.instructorId DESC",   // HQL query
                            InstructorEntyty.class                              // return type (entity class)
                    )
                    .setMaxResults(1)                                // eka result witharai ganna
                    .uniqueResultOptional()                          // Optional<UserEntyty> return wenawa
                    .orElse(null);                                   // result nathnam null return karanawa
            System.out.println("===============================");
            System.out.println(entyty.getInstructorId());
            System.out.println("===============================");
            return entyty.getInstructorId();
//           return lastUser;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public String findNameById(String Id) throws Exception {
        return "";
    }

    @Override
    public InstructorEntyty getInstructorEntyById(String id) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        InstructorEntyty instructor = null;

        try {
            transaction = session.beginTransaction();

            instructor = session.get(InstructorEntyty.class, id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return instructor;
    }

}
