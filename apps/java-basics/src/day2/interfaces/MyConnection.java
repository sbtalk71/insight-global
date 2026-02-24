package day2.interfaces;

public interface MyConnection {
   String releaseversion="1.0";
    String getConnection();
    String getDbDetails();
    default String getDriverVersion(){
        throw new IllegalArgumentException("not implemented");
    }

}
