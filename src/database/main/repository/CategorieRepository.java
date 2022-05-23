package database.main.repository;

import classes.Autor;
import classes.Categorie;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategorieRepository {
    public static void adaugaCategorie(Categorie categorie){
        String query = "insert into categorie values (?, ?,?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, categorie.getNume());
            statement.setInt(2, categorie.getEtaj());
            statement.setInt(3, categorie.getraft());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static ArrayList<Categorie> load() throws SQLException {
        String query = "select * from categorie";
        ArrayList<Categorie> categorii= new ArrayList<>();
        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            Categorie categorie= new Categorie(result);
            categorii.add(categorie);
        }
        return categorii;

    }
}
