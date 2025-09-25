package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.EnrolmentDAO;
import edu.project.lernessschool.demo.Dto.Enrolment;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EnrolmentDAOImpl implements EnrolmentDAO {

    @Override
    public List<EnrollmentEntyty> getAllenrolments() {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // HQL query to fetch all enrollment entities
            List<EnrollmentEntyty> list = session.createQuery(
                    "FROM EnrollmentEntyty", EnrollmentEntyty.class
            ).list();

            transaction.commit();
            return list;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return List.of(); // return empty list if error
        } finally {
            session.close();
        }
    }

    @Override
    public List<EnrollmentEntyty> getEnrollmentsfromIdandcourseid(String studentId, String courseId) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Fetch matching entities
            List<EnrollmentEntyty> entities = session.createQuery(
                            "FROM EnrollmentEntyty e " +
                                    "WHERE e.student.studentId = :studentId AND e.course.courseId = :courseId",
                            EnrollmentEntyty.class)
                    .setParameter("studentId", studentId)
                    .setParameter("courseId", courseId)
                    .list();

            transaction.commit();

            // Convert entities -> DTOs


            return entities;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return List.of();
        } finally {
            session.close();
        }
    }


    @Override
    public List<Enrolment> getAll() throws Exception {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return null;
    }

    @Override
    public Boolean update(Enrolment enrolment) throws Exception {
        return null;
    }

    @Override
    public Boolean save(Enrolment enrolment) throws Exception {
        return null;
    }

    @Override
    public String getNextId() throws Exception {
        return "";
    }

    @Override
    public String findNameById(String Id) throws Exception {
        return "";
    }
}
