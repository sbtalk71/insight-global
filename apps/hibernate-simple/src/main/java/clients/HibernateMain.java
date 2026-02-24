package clients;


import com.demo.entities.Address;
import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(Emp.class);

       SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

       try{
           Emp emp=new Emp(200,"Tom","Mumbai",45000,20);
           Address address=new Address("123","Street 2","5000097");
           emp.setAddress(address);
            emp.getImages().add("image1");
            emp.getImages().add("image2");
            emp.getImages().add("image3");
          session.persist(emp);

           tx.commit();
       }catch (HibernateException e){
           tx.rollback();
           e.printStackTrace();
       }finally {
           session.close();
           sessionFactory.close();
       }
    }
}
