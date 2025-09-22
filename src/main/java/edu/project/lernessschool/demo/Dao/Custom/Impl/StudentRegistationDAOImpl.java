package edu.project.lernessschool.demo.Dao.Custom.Impl;

import edu.project.lernessschool.demo.Configeretion.FactoryConfigaretion;
import edu.project.lernessschool.demo.Dao.Custom.StudentRegistationDAO;
import edu.project.lernessschool.demo.Entyty.CourseEntyty;
import edu.project.lernessschool.demo.Entyty.EnrollmentEntyty;
import edu.project.lernessschool.demo.Entyty.StudentEntyty;
import edu.project.lernessschool.demo.Entyty.UserEntyty;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRegistationDAOImpl implements StudentRegistationDAO {
    @Override
    public List<StudentEntyty> getAll() throws Exception {
        return List.of();
    }

    @Override
    public Boolean delete(String id) throws Exception {
        return null;
    }

    @Override
    public Boolean update(StudentEntyty studentEntyty) throws Exception {
        return null;
    }

//    @Override
//    public Boolean save(StudentEntyty studentEntyty) throws Exception {
//
//        Session session = FactoryConfigaretion.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//
//
//            List<EnrollmentEntyty> enrollmentEntyties = studentEntyty.getEnrollments();
//            List<EnrollmentEntyty> enrollmentEntyties2 = studentEntyty.getEnrollments();
//
//            for (EnrollmentEntyty enrollmentEnty : enrollmentEntyties) {
//
//                EnrollmentEntyty entyty = new EnrollmentEntyty();
//                entyty.setEnrollmentDate(enrollmentEnty.getEnrollmentDate());
//                entyty.setFirstPayment(enrollmentEnty.getFirstPayment());
//                entyty.setStatus(enrollmentEnty.getStatus());
//                entyty.setStudent(studentEntyty);
//
//                enrollmentEntyties2.add(entyty);
//
//            }
//
//            studentEntyty.setEnrollments(enrollmentEntyties2);
//
//            session.persist(studentEntyty);
//            transaction.commit();
//
//            return true;
//
//
//        } catch (Exception e) {
//            if(transaction!=null){
//                transaction.rollback();
//            }
//
//            e.printStackTrace();
//            return false;
//        }
//
//
//    }

    @Override
    public Boolean save(StudentEntyty studentEntyty) throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {

            for (EnrollmentEntyty enrollment : studentEntyty.getEnrollments()) {
                CourseEntyty course =enrollment.getCourse();

                System.out.println(  course.getCoureName());
             CourseEntyty courseEntyty =getCourseEntyByname( course.getCoureName());

                enrollment.setCourse(courseEntyty);
                courseEntyty.setEnrollmentEntytys(studentEntyty.getEnrollments());
//                ========================================
                enrollment.setStatus("Active");
                enrollment.setStudent(studentEntyty);
            }

            session.persist(studentEntyty);
            transaction.commit();

            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public String getNextId() throws Exception {
        Session session = FactoryConfigaretion.getInstance().getSession();

        try {

//            StudentEntyty

            StudentEntyty studentEntyty    = session.createQuery(
                            "FROM StudentEntyty s ORDER BY s.studentId DESC",   // HQL query
                            StudentEntyty.class                              // return type (entity class)
                    )
                    .setMaxResults(1)                                // eka result witharai ganna
                    .uniqueResultOptional()                          // Optional<UserEntyty> return wenawa
                    .orElse(null);                                   // result nathnam null return karanawa



            if(studentEntyty==null){
                return null;

            }else {
                String avelableId =studentEntyty.getStudentId();
                return avelableId;
            }


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
    public CourseEntyty getCourseEntyByname(String name) {

        Transaction transaction = null;
        CourseEntyty course = null;

        try (Session session = FactoryConfigaretion.getInstance().getSession()) {
            transaction = session.beginTransaction();

            // HQL query to find course by name
//            course = session.createQuery(
//                            "FROM CourseEntyty c WHERE c.name = :name", CourseEntyty.class)
//                    .setParameter("name", name)
//                    .uniqueResult();

            course = session.createQuery(
                            "FROM CourseEntyty c WHERE c.coureName = :name", CourseEntyty.class)
                    .setParameter("name", name)
                    .uniqueResult();


            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public StudentEntyty getStudentEntytyById(String id) {
        Session session = FactoryConfigaretion.getInstance().getSession();
        Transaction transaction = null;
        StudentEntyty studentEntyty = null;

        try {
            transaction = session.beginTransaction();

            studentEntyty= session.get(StudentEntyty.class, id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }

        return studentEntyty;
    }
}
