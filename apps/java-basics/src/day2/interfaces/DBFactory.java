package day2.interfaces;

import java.util.Optional;

public class DBFactory {
   public static Optional<MyConnection> getDb(String dbType){
       if(dbType.equals("oracle")){
           return Optional.of(new OracleDB());
       } else if (dbType.equals("mysql")) {
           return Optional.of(new MySqlDB());
       }else{
           return Optional.empty();
       }
   }
}
