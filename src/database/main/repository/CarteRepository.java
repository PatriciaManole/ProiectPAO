package database.main.repository;

import classes.*;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarteRepository {
    public static ArrayList<Carte> load() throws SQLException {
        String query = "select * from carte";
        String query1 = "select * from autor";
        String query2 = "select * from categorie";
        String query3 = "select * from editura";
        ArrayList<Carte> carti = new ArrayList<>();
        ArrayList<Autor> autori = new ArrayList<Autor>();
        ArrayList<Editura> edituri = new ArrayList<Editura>();
        ArrayList<Categorie> categorii= new ArrayList<>();

        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result1 = statement.executeQuery(query1);
        while (result1.next()){
            Autor autor= new Autor(result1);
            autori.add(autor);
        }

        Statement statement2= DbConnection.getInstance().createStatement();
        ResultSet result2 = statement2.executeQuery(query2);
        while (result2.next()){
            Categorie categorie= new Categorie(result2);
            categorii.add(categorie);
        }
        Statement statement3= DbConnection.getInstance().createStatement();
        ResultSet result3 = statement3.executeQuery(query3);
        while (result3.next()){
            Editura editura= new Editura(result3);
            edituri.add(editura);
        }

        Statement statement4= DbConnection.getInstance().createStatement();
        ResultSet result = statement4.executeQuery(query);
        while (result.next()){
            String nume = result.getString("Titlu");
            String numeAutor = result.getString("NumeAutor");
            String numeEditura = result.getString("NumeEditura");
            String isbn = result.getString("isbn");
            String numeCategorie = result.getString("NumeCategorie");

            Autor autor = null;
            Editura editura = null;
            Categorie categorie = null;

            for(Autor a:autori){
                if(a.getNume().equals(numeAutor)){
                    autor = a;
                }
            }

            for(Editura e : edituri){
                if(e.getNume().equals(numeEditura)){
                    editura = e;
                }
            }

            for(Categorie c: categorii){
                if(c.getNume().equals(numeCategorie)){
                    categorie = c;
                }
            }

            Carte carte_noua = new Carte(nume, autor, editura, isbn, categorie);
            carti.add(carte_noua);

        }
        return carti;
    }

    public static void adaugaCarte(Carte carte){
        String query = "insert into carte values ( ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, carte.getTitlu());
            statement.setString(2, carte.getAutor().getNume());
            statement.setString(3, carte.getEditura().getNume());
            statement.setString(4, carte.getIsbn());
            statement.setString(5, carte.getCategorie().getNume());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
