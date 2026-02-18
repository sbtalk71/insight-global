package clients;


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
           Emp emp=new Emp(202,"Tom","Mumbai",45000,20);
          session.persist(emp);
          session.remove(emp);
//          session.flush();
//          Thread.sleep(20000);
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
