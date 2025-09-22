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
import org.hibernate.query.Query;

import java.util.List;

public class LessionShedulDAOImpl implements LessionShedulDAO {
    @Override
    public String getStudentIdNumber(List<String> nameAndPhoneNumber) {

        System.out.println("===============================ou ou eka thamai");
        // phone = 0 index, name = 1 index
        String studentPhone = nameAndPhoneNumber.get(1);

        String studentName = nameAndPhoneNumber.get(0);
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
    public boolean savemethod(LessionsEntyty entyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        System.out.println("====== dan inne save method eke====");
        try {
            transaction = session.beginTransaction();

            System.out.println("====== dan inne session.persist(lessionsEntyty); eka laga====");
            session.persist(entyty);
            System.out.println(true);
            System.out.println("====== dan inne session.persist(lessionsEntyty); eka  yata====");

            transaction.commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Replace with proper logging later
            return false;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<LessionsEntyty> getReleventLessionObjects(String courseId, String date, String time, String instructorId) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        try {
            String hql = "FROM LessionsEntyty l " +
                    "WHERE l.course.courseId = :courseId " +
                    "AND l.date = :date " +
                    "AND l.time = :time " +
                    "AND l.instructor.instructorId = :instructorId";
            Query<LessionsEntyty> query = session.createQuery(hql, LessionsEntyty.class);
            query.setParameter("courseId", courseId);
            query.setParameter("date", date); // assuming date is in "YYYY-MM-DD"
            query.setParameter("time", time);
            query.setParameter("instructorId", instructorId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
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
