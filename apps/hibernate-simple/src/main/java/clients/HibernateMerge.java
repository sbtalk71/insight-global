package clients;


import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMerge {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(Emp.class);

       SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

       try{
           Emp emp=session.get(Emp.class,200);
           session.evict(emp);

           emp.getImages().add("merge2");
           session.merge(emp);
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
