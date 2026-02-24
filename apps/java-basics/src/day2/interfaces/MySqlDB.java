package day2.interfaces;

public class MySqlDB implements MyConnection{

    @Override
    public String getConnection() {
        return "MySql DB Connected";
    }

    @Override
    public String getDbDetails() {
        return "Mysql 8";
    }
}
