package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPABootstrap {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        System.out.println("Result: " + em.createNativeQuery("select 1 + 1").getSingleResult());




        User user = new User();
        user.setName("ManéGil");
        user.setId(101);
        user.setEmail("manegil@g.com");

        User user1 = new User();
        user1.setName("Rita");
        user1.setId(102);
        user1.setEmail("rita@g.com");

        Account acc = new Account();
        acc.setAccId(2);
        acc.setUser(user);
        acc.setBalance(20000);
        acc.setAccType(Account.AccType.CHECKING);

        Account acc1 = new Account();
        acc1.setAccId(1);
        acc1.setUser(user1);
        acc1.setBalance(50000);
        acc1.setAccType(Account.AccType.SAVING);

        Address address = new Address();
        address.setCity("5555");
        address.setStreet("Code Street");
        address.setCity("Booow city");

        em.getTransaction().begin();
        em.persist(user);
        em.persist(acc);
        em.persist(user1);
        em.persist(acc1);
        em.persist(address);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}