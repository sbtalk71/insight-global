package day2.interfaces;

public class PostGresDb implements MyNewConnection{

    @Override
    public String getConnection() {
        return "PostGres DB Connected";
    }

    @Override
    public String getDbDetails() {
        return "PostGres 16";
    }

    @Override
    public String productDetails() {
        return "Postgres Enterprise";
    }
}
