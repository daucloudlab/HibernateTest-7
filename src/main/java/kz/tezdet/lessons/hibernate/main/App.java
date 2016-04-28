package kz.tezdet.lessons.hibernate.main;

import kz.tezdet.lessons.hibernate.models.Student;
import kz.tezdet.lessons.hibernate.models.Test;
import kz.tezdet.lessons.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory() ;
        Session session = sessionFactory.openSession() ;
        Transaction tx = session.beginTransaction() ;

        Student student1 = new Student("Nagesh", "Chauhan",
                "beingjavaguy@gmail.com", "8789876765");
        Student student2 = new Student("Shweta", "Chauhan", "shweta@gmail.com",
                "8767598786");

        Test test1 = new Test("Maths", "100", "87", "Passed");
        Test test2 = new Test("Science", "100", "90", "Passed");

        student1.getTests().add(test1);
        student1.getTests().add(test2);
        student2.getTests().add(test1);
        student2.getTests().add(test2);

        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close() ;
    }
}
