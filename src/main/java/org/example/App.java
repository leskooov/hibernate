package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

//            Person person = session.get(Person.class,1);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());

            Person person1 = new Person("Test1", 20);
            Person person2 = new Person("Test2",30);
            Person person3 = new Person("Test3",25);

            session.save(person1);
            session.save(person2);
            session.save(person3);
            session.getTransaction().commit();
        }finally {

            sessionFactory.close();
        }

    }
}
