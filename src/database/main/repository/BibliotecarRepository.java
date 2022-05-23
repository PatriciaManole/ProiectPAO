package database.main.repository;

import classes.Bibliotecar;
import classes.Client;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BibliotecarRepository {
    public static ArrayList<Bibliotecar> load() throws SQLException {
        String query = "select * from persoana";
        ArrayList<Bibliotecar> bibliotecari = new ArrayList<>();
        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            Bibliotecar bibliotecar= new Bibliotecar(result);
            bibliotecari.add(bibliotecar);
        }
        return bibliotecari;
    }

    public static void adaugaBibliotecar(Bibliotecar bibliotecar){
        String query = "insert into persoana values ( ?, ?, ?, ?, ?, null, null, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, bibliotecar.getNume());
            statement.setString(2, bibliotecar.getPrenume());
            statement.setString(3, bibliotecar.getEmail());
            statement.setString(4, bibliotecar.getNrTelefon());
            statement.setString(5, bibliotecar.getAdresa());
            statement.setString(6, bibliotecar.getDataAngajare());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
