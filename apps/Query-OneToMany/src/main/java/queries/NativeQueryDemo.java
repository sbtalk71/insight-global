package queries;

import com.demo.entities.Emp;
import jakarta.persistence.*;

import java.util.List;

public class NativeQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println(em.getClass().getName());

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createNativeQuery("select name,salary from EMPLOYEE where salary>5000", EmpData.class);
            //Query query = em.createNativeQuery("select new queries.EmpData(name,salary) from EMPLOYEE where salary>5000");

            List<EmpData> empList = query.getResultList();

            empList.stream().forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));

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
