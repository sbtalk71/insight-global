package clients;

import com.demo.entities.Address;
import com.demo.entities.Emp;
import jakarta.persistence.*;


public class JpaMain1 {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-jpa");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();

        try{
            Emp emp = new Emp(301,"Srinivas","Kolkata",670000,10);
            Address address=new Address("222","Street 5","700001");
            emp.getImages().add("photo1");
            emp.getImages().add("photo2");
            emp.getImages().add("photo3");

            tx.begin();
            em.persist(emp);
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
