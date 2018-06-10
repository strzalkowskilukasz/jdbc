package dao;

import config.Database;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    //save
    //update
    //delete
    //find by id
    //find all

    private Database database = new Database();

    public User save(User user) throws SQLException {
        //insert
        //1. pobierz połączenia
        Connection connection = database.getConnection();

        //2. napisz zapytanie
//        String sql = "INSERT INTO user(first_name, last_name, email) " +
//                "VALUES ("+ user.getFirstName() + "," + user.getLastName() + "," + user.getEmail() + ")";
                //nie trzeba łamać tego wiersza IntelliJ sam dodaje dwa stringi
        //! tAK NIE ROBIMY ZE WZGLĘDU NA SQL INJECTIOP !"
        String sql = "INSERT INTO user(first_name, last_name, email) VALUES (?,?,?)";

        //3. utworz obiekt PreparedStatement
        PreparedStatement statement = connection.prepareStatement(sql);

        //4. uzupełnij parametry zapytania
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());

        //parametr index to kolejne znaki zapytania, wykorzystujemy wszędzie tam, gdzie podajemy dane

        //5. wykonaj zapytanie w bazie
        statement.executeUpdate();

        return user;
        //metoda save nie musi właściwie nic zwracać- może być voidem.
    }

    public void update(User user) {

    }

    public void delete(int id) {

    }

    public User findById(int id) {
    return null;
    }

    public List<User> findAll() {
    return null;
    }
}
