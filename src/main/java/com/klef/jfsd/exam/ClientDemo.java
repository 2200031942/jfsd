package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {
        // Load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        
        // Build SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        
        // Perform update operation
        updateDepartment(sessionFactory, 1, "Updated Name", "Updated Location");
    }

    public static void updateDepartment(SessionFactory sessionFactory, int departmentId, String newName, String newLocation) {
        Session session = null;
        Transaction transaction = null;

        try {
            // Open session and begin transaction
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            // HQL Update query with positional parameters
            String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE id = ?3";
            int updatedRecords = session.createQuery(hql)
                                        .setParameter(1, newName)
                                        .setParameter(2, newLocation)
                                        .setParameter(3, departmentId)
                                        .executeUpdate();
            
            System.out.println("Number of records updated: " + updatedRecords);
            
            // Commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
