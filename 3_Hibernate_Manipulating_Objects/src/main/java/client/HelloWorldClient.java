package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Message;


public class HelloWorldClient {
	public static void main(String[] args) {
                Transaction transaction = null;
	    
        		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        		    transaction = session.getTransaction();
        			transaction.begin();
        	
        			//Finding objects
        			
        			Message msg = (Message) session.get(Message.class, 2L);
        			
        			
        			//Updating objects
        			/*
        			Message msg = (Message) session.get(Message.class, 2L);
        			msg.setText( “Hello Automatic Dirty Checking” );
        			*/
        			
        			//Deleting objects
        			/*
        			Message msg = (Message) session.get(Message.class, 2L);  
        			session.delete(msg);
        			*/

                    System.out.println(msg);
	        
	        		transaction.commit();
        		}	catch(Exception e) {
	        			if(transaction != null) { 
	        			    transaction.rollback(); 
	        			}
	        			e.printStackTrace();
        		}
	
	}
}




