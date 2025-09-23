package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.PaymentDAO;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.PaymentEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public List<PaymentEntyty> getAll() throws Exception {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return null;
    }

    @Override
    public Boolean update(PaymentEntyty paymentEntyty) throws Exception {
        return null;
    }

    @Override
    public Boolean save(PaymentEntyty paymentEntyty) throws Exception {
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


    @Override
    public String getStudentIdNumber(String ponenumber) throws Exception {

        System.out.println("===============================ou ou eka thamai");

        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // HQL query to fetch studentId by name + phone

//            StudentEntyty
            String studentId = session.createQuery(
                            "select s.studentId from StudentEntyty s " +
                                    "where s.pnumber = :phone",
                            String.class
                    )
                    .setParameter("phone", ponenumber)
                    .uniqueResult();

            transaction.commit();
            return studentId; // found ID or null

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<EnrollmentEntyty> getallCoursesForStudent(String idNumber) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<EnrollmentEntyty> enrollments = session.createQuery(
                            "from EnrollmentEntyty e " +
                                    "where e.student.studentId = :studentid", EnrollmentEntyty.class)
                    .setParameter("studentid", idNumber)
                    .getResultList();

            transaction.commit();
            return enrollments;

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return List.of(); // return empty list if error
        } finally {
            session.close();
        }
    }
}
