package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Guide;
import entity.Student;


public class HelloWorldClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction transaction = session.getTransaction();
        		try {
        			transaction.begin();
        			
					// persisting Student object
                    Guide guide = new Guide("2000IM10901", "Ian Lamb", 2000);
        			Student student1 = new Student("2014JT50123", "John Smith", guide);

					Student student2 = new Student("2014AL50456", "Amy Gill", guide);

					session.persist(student1);
                    session.persist(student2);
                    
                    transaction.commit();
                    
					// deleting Student object
                    
                    transaction = session.getTransaction();
                    
        			student2 = (Student) session.get(Student.class, 2L);
        			session.delete(student2);
                    
        			student1 = (Student) session.get(Student.class, 1L);
                    session.delete(student1);

    
	        		transaction.commit();
        		}	catch(Exception e) {
	        			if(transaction != null) { transaction.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}



