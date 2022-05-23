package database.main.repository;

import classes.Autor;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutorRepository {
    public static void adaugaAutor(Autor autor) {
        String query = "insert into autor values ( ?, ?, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, autor.getNume());
            statement.setString(2, autor.getPrenume());
            statement.setString(3, autor.getTara());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Autor> load() throws SQLException {
        String query = "select * from autor";
        ArrayList<Autor> autori = new ArrayList<>();
        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            Autor autor= new Autor(result);
            autori.add(autor);
        }
        return autori;

    }

}
