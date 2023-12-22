/*
package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class JPA {
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    User user;

    public User findById(Integer id) {

        // open a new connection to the database
        entityManager = entityManagerFactory.createEntityManager();

        try {
            // fetch a new user using its id
            return entityManager.find(User.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    public User saveOrUpdate(User user) {

        entityManager = entityManagerFactory.createEntityManager();

        try {

            entityManager.getTransaction().begin(); // open transaction
            User savedCustomer = entityManager.merge(user);
            entityManager.getTransaction().commit(); // close transaction
            return savedCustomer;

        } catch (RollbackException ex) {

            // something went wrong, make sure db is consistent
            entityManager.getTransaction().rollback();
            return null;

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
*/
