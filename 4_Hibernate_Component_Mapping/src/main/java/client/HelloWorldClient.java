
package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Address;
import entity.Person;


public class HelloWorldClient {
	public static void main(String[] args) {
	    
        		Transaction transaction = null;
        		
        		try (Session session = HibernateUtil.getSessionFactory().openSession()){
                    transaction = session.getTransaction();
        			transaction.begin();
        	
        			//Address address = new Address("200 E Main St", "Seattle", "85123");
        			//Person person = new Person("Ruby", address);
        	
        			//session.save(person);
                    
                    Person person = session.get(Person.class, 2L);
                    System.out.println(person);
	        
	        		transaction.commit();
        		}	catch(Exception e) {
	        			if(transaction != null) { 
	        			    transaction.rollback(); 
	        			}
	        			e.printStackTrace();
        		}
	
	}
}












