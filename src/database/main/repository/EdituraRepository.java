package database.main.repository;

import classes.Autor;
import classes.Editura;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EdituraRepository {
    public static void adaugaEditura(Editura editura) {
        String query = "insert into editura values ( ?, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, editura.getNume());
            statement.setString(2, editura.getAdresa());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Editura> load() throws SQLException {
        String query = "select * from editura";
        ArrayList<Editura> edituri = new ArrayList<>();
        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            Editura editura= new Editura(result);
            edituri.add(editura);
        }
        return edituri;

    }
}
