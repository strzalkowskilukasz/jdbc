package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements Pass {

    //https://github.com/strzalkowskilukasz - strony
    //jdbc:mysql://localhost:3306/java_app - bazy danych zamiast localhost 127.0.0.1:3306/java_app


    private Connection connection;

    public Database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Brak drivera do bazy");
            System.exit(-1); // Wychodzimy z aplikacji z kodem błędu "-1" - minusowa wartość mówi o błędzie. Przyjęte -1 z dupy.
        }
    }

    public Connection getConnection() throws SQLException {
           if (connection == null) { // zalezy nam na tym, że łączyć się jak najrzadziej z bazą.
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

}
