package com.demo.table.subclass;

import com.demo.table.subclass.TraineeEmp;
import jakarta.persistence.*;

public class UpdateMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();

        try{
            tx.begin();
            TraineeEmp te= em.find(TraineeEmp.class,4);
            te.setSalary(67000);
            te.setPerformance("Excellent");
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
