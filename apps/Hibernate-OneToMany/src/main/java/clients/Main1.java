package clients;

import com.demo.entities.Dept;
import com.demo.entities.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main1 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(Emp.class);
        cfg.addAnnotatedClass(Dept.class);

      SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        try{

            Dept dept=session.get(Dept.class,20);
            for(Emp e:dept.getEmps()){
                System.out.println(e.getEmpName()+" "+e.getCity()+" "+dept.getManager());
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
