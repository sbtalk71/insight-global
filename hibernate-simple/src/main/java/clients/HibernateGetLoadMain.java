package clients;


import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateGetLoadMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(Emp.class);

       SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

       try{
           Emp emp=session.load(Emp.class,301);
           session.remove(emp);
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
