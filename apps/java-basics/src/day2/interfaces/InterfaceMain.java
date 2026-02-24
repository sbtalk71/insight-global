package day2.interfaces;

import java.util.Optional;

public class InterfaceMain {
    public static void main(String[] args) {

        //MyConnection conn=new OracleDB();
       Optional<MyConnection> conn=DBFactory.getDb("oracles");

       if(conn.isPresent()) {
           System.out.println(conn.get().getConnection());
           System.out.println(conn.get().getDbDetails());
       }else{
           System.out.println("not supported...");
       }
    }
}
