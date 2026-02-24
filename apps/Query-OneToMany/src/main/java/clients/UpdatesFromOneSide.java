package clients;

import com.demo.entities.Dept;
import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatesFromOneSide {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(Emp.class);
        cfg.addAnnotatedClass(Dept.class);

      SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        try{

            Dept dept=new Dept(51,"Taxes","Ravikanth");
           Emp emp1=new Emp(204,"Chanchal","Hyderabad",56000);
           Emp emp2=new Emp(205,"Chanchal","Hyderabad",56000);
            emp1.setDept(dept);
            emp2.setDept(dept);
            session.persist(dept);

            session.persist(emp1);
            session.persist(emp2);
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
