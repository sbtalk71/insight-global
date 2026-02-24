package queries;

import com.demo.entities.Emp;
import jakarta.persistence.*;

import java.util.List;

public class NamedQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.getClass().getName());


        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createNamedQuery("query1a");
           // query.setParameter(1,"Hyderabad");
            query.setParameter("mycity","Hyderabad");

            List<Emp> empList = query.getResultList();

            empList.stream().forEach(e -> System.out.println(e.getEmpId() + " " + e.getEmpName()));
            empList.stream().forEach(e -> System.out.println(e.getEmpId() + " " + e.getEmpName()+" "+e.getDept().getDeptNo()));
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
