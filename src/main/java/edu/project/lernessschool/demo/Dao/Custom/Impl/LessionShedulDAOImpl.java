package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.LessionShedulDAO;
import edu.project.lernessschool.demo.Dao.DAOFactory;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.LessionsEntyty;
import edu.project.lernessschool.demo.Entyty.StudentEntyty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LessionShedulDAOImpl implements LessionShedulDAO {
    @Override
    public String getStudentIdNumber(List<String> nameAndPhoneNumber) {

        System.out.println("===============================ou ou eka thamai");
        // phone = 0 index, name = 1 index
        String studentPhone = nameAndPhoneNumber.get(1);

        String studentName  =   nameAndPhoneNumber.get(0);
        System.out.println("studentPhone: " + studentPhone);
        System.out.println("studentName: " + studentName);

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
                    .setParameter("phone", studentPhone)
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
    public List<EnrollmentEntyty> getallCoursesForStudent(String studentId) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<EnrollmentEntyty> enrollments = session.createQuery(
                            "from EnrollmentEntyty e " +
                                    "where e.student.studentId = :studentid", EnrollmentEntyty.class)
                    .setParameter("studentid", studentId)
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
    public List<LessionsEntyty> getAll() throws Exception {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return null;
    }

    @Override
    public Boolean update(LessionsEntyty lessionsEntyty) throws Exception {
        return null;
    }

    @Override
    public Boolean save(LessionsEntyty lessionsEntyty) throws Exception {
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
