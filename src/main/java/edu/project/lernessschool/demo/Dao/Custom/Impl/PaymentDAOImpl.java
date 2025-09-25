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

    @Override
    public String getFirstPayment(String studentId, String courseId) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("dan inne ekkeee=====================");

        try {
            System.out.println("dan inne ============quariya uda=========");
            EnrollmentEntyty enrollment = session.createQuery(
                            "FROM EnrollmentEntyty e " +
                                    "WHERE e.student.studentId = :studentId AND e.course.courseId = :courseId",
                            EnrollmentEntyty.class)
                    .setParameter("studentId", studentId)
                    .setParameter("courseId", courseId)
                    .uniqueResult();
            System.out.println("dan inne ============quariya yata=========");
            System.out.println(enrollment.toString());
            System.out.println(enrollment);
            System.out.println("dan inne ============quariya run karama aut puts=========");

            transaction.commit();

            if (enrollment != null) {
                System.out.println("=============dsds================");
                System.out.println(enrollment.getFirstPayment());
                System.out.println("=============dsfd================");
                return String.valueOf(enrollment.getFirstPayment()); // return as String

            } else {
                return null; // no matching record
            }
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
