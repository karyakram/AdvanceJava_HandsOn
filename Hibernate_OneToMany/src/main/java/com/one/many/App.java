package com.one.many;

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
        Configuration con = new Configuration();
        con.configure("hibernate.cfg.xml");
        // Prepare the transaction
      
        		SessionFactory sf = con.buildSessionFactory( );
        		Session session = sf.openSession();
        		Transaction tx = session.beginTransaction(); 
        		
        		// ********* create 2 students *********
        		Student student_1 = new Student();
        		student_1.setEmail("student_1@mail.com");
        		student_1.setName("Amit");
        		Student student_2 = new Student();
        		student_2.setEmail("student_2@mail.com");
        		student_2.setName("Sumit");
        		
        		// ********* create 2 addresses *********
        		 Address address1=new Address();    
        	        address1.setAddressLine1("111,Kotla Mubarkpur");    
        	        address1.setCity("South Ex");    
        	        address1.setState("New Delhi");    
        	        address1.setCountry("India");    
        	        address1.setPincode(110003);
        	        
        	        
        	        Address address2 = new Address();
        	        address2.setAddressLine1("111,Kotla Mubarkpur");    
        	        address2.setCity("South Ex");    
        	        address2.setState("New Delhi");    
        	        address2.setCountry("India");    
        	        address2.setPincode(110003);
        		
        		// ********* Assign addresses to students *********
        		student_1.setAddress(address1);
        		student_2.setAddress(address2);
        		// Save addresses to session
        		session.saveOrUpdate(address1);
        		session.saveOrUpdate(address2);
        		// 
        		// ********* create 3 accounts *********
        		Account account1 = new Account();
        		account1.setUsername("happy_1");
        		Account account2 = new Account();
        		account2.setUsername("happy_2");
        		Account account3 = new Account();
        		account3.setUsername("icecream_1");
        		// ********* Assign accounts to students *********
        		student_1.getAccounts().add(account1);
        		student_1.getAccounts().add(account2);
        		student_2.getAccounts().add(account3);
        		// ********* Save students *********
        		session.save(student_1);
        		session.save(student_2);
        		tx.commit();
        		
    }
}