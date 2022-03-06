package com.org.day17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();  
          
        Transaction t=session.beginTransaction();   
          
        Student s1=new Student();    
        s1.setName("Shivam");    
        s1.setEmail("shivam@gmail.com");    
            
        Address address1=new Address();    
        address1.setAddressLine1("111,Kotla Mubarkpur");    
        address1.setCity("South Ex");    
        address1.setState("New Delhi");    
        address1.setCountry("India");    
        address1.setPincode(110003);    
            
        s1.setAddress_id(address1);    
        address1.setStudent(s1);    
            
        session.persist(s1);    
        t.commit();    
            
        session.close();    
        System.out.println("success");    
    }    
    }    