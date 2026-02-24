package queries;

import com.demo.entities.Emp;
import jakarta.persistence.*;

import java.util.List;

public class ProjectionQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.getClass().getName());
        

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
           // Query query = em.createNamedQuery("query2");

//            List<Object[]> empList = query.getResultList();
//            for(Object[] data:empList){
//                String name=(String) data[0];
//                double salary=(Double)data[1];
//                System.out.println(name+" "+salary);
//            }

            Query query = em.createNamedQuery("query3");

            List<EmpData> dataList=query.getResultList();
            dataList.stream().forEach(e-> System.out.println(e.getName()+" "+e.getSalary()));


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
