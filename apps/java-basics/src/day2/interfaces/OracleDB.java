package day2.interfaces;

public class OracleDB implements MyConnection{

    @Override
    public String getConnection() {
        return "Oracle DB Connected";
    }

    @Override
    public String getDbDetails() {
        return "Oracle database 9i";
    }
}
