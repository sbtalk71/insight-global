package clients;

import com.demo.entities.Dept;
import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatesFromManySide {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(Emp.class);
        cfg.addAnnotatedClass(Dept.class);

      SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        try{
            Dept dept=new Dept(52,"Taxes","Ravikanth");
           dept.getEmps().add(new Emp(206,"rahul","Pune",45000));
           dept.getEmps().add(new Emp(207,"Chanchal","Hyderabad",56000));
           session.persist(dept);
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
