package queries;

import com.demo.entities.Emp;
import jakarta.persistence.*;

import java.util.List;

public class JoinQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.getClass().getName());


        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createNamedQuery("joinquery");


            List<Object[]> dataList = query.getResultList();

           for(Object[] data:dataList){
               String name=(String)data[0];
               double salary=(Double)data[1];
               String dname=(String)data[2];
               String manager=(String)data[3];
               System.out.println(name+" "+salary+" "+dname+" "+manager);
           }
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
