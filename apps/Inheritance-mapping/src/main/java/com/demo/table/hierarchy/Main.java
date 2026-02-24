package com.demo.table.hierarchy;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();

        try{
            tx.begin();
            Person person=new Person("Thor",2);
            em.persist(person);

            Employee emp= new Employee("Joker",3,45000);
            em.persist(emp);

            TraineeEmp te= new TraineeEmp("Thanos",4,10000,"good");
            em.persist(te);
            tx.commit();
        }catch (PersistenceException e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
