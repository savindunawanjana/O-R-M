package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.CourseDAO;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.InstructorEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<CourseEntyty> getAll() throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<CourseEntyty> courseEntytiesList = new ArrayList<>();

        try {


            courseEntytiesList = session.createQuery("from CourseEntyty", CourseEntyty.class)
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

        return courseEntytiesList;
    }

    @Override
    public Boolean delete(String id) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {

            CourseEntyty courseEntyty = session.get(CourseEntyty.class, id);

            if (courseEntyty != null) {
                session.delete(courseEntyty);
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
    public Boolean update(CourseEntyty courseEntyty) throws Exception {
        System.out.println("updete methode eka Course dao eke");

        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(courseEntyty);
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
    public Boolean save(CourseEntyty courseEntyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            session.persist(courseEntyty);

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
      return null;

    }

    @Override
    public String findNameById(String Id) throws Exception {
        return "";
    }

    @Override
    public CourseEntyty getLastId() {
        Session session = FactoryConfigaretion.getInstance().getSession();

        try {
            return session.createQuery(
                            "FROM CourseEntyty u ORDER BY u.courseId DESC",   // HQL query
                            CourseEntyty.class                              // return type (entity class)
                    )
                    .setMaxResults(1)                                // eka result witharai ganna
                    .uniqueResultOptional()                          // Optional<UserEntyty> return wenawa
                    .orElse(null);                                   // result nathnam null return karanawa

//            return courseEntyty.getCourseId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }

    }

    @Override
    public CourseEntyty getCoursEntytyById(String id) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        CourseEntyty courseEntyty = null;

        try {
            transaction = session.beginTransaction();

            courseEntyty= session.get(CourseEntyty.class, id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return courseEntyty;
    }
}
