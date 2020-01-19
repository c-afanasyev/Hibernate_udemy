
package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Guide;
import entity.Student;


public class HelloWorldClient {
	public static void main(String[] args) {
		
        		Transaction transaction = null;
        		
        		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    transaction = session.getTransaction();
        			transaction.begin();
                    /*        	
        			Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
        			Student student = new Student("2014JT50123", "John Smith", guide);

        			session.save(guide);
        			session.save(student);
	                */
                    
                    Student student = session.get(Student.class, 1L);
                    
	        		transaction.commit();

        		}	catch(Exception e) {
	        			if(transaction != null) { transaction.rollback(); }
	        			e.printStackTrace();
        		}	
	
	}
}











