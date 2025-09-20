package edu.project.lernessschool.demo.Configeretion;

import edu.project.lernessschool.demo.Entyty.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfigaretion {

    private static FactoryConfigaretion factoryConfigaretion;
    private SessionFactory sessionFactory;

    private FactoryConfigaretion(){

        Configuration configuration=new Configuration().configure("hibernate.cfg.xml"); //fxma
        configuration.addAnnotatedClass(UserEntyty.class);
        configuration.addAnnotatedClass(InstructorEntyty.class);
        configuration.addAnnotatedClass(StudentEntyty.class);
        configuration.addAnnotatedClass(EnrollmentEntyty.class);
        configuration.addAnnotatedClass(CourseEntyty.class);

        sessionFactory= configuration.buildSessionFactory();
    }
    //me method eka run unama thamai  hipernet bustrctwenne
    //haipernet ekak mulinma run wenne methanadi me awasthawata thamai haibernet bustrctwenne wenawa kiyanne

    public static FactoryConfigaretion getInstance(){
        if(factoryConfigaretion==null){
            factoryConfigaretion=new FactoryConfigaretion();
        }
        return factoryConfigaretion;
    }

    //section eliyata ganna puluwan meken
    public Session getSession(){
        Session session=sessionFactory.openSession();
        return session;


    }







}

