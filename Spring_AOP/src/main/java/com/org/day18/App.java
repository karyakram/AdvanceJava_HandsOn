package com.org.day18;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        
        Operation op = (Operation) context.getBean("opBean");  
        op.msg();  
        op.display();  
    }
}
