package database.main.repository;

import classes.Client;
import classes.Editura;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientRepository {
    public static void adaugaClient(Client client){
        String query = "insert into persoana values ( ?, ?, ?, ?, ?, ?, ?, null)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getNrTelefon());
            statement.setString(5, client.getAdresa());
            statement.setString(6, String.valueOf(client.getTipClient()));
            statement.setInt(7, client.getLegitimatie());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Client> load() throws SQLException {
        String query = "select * from persoana";
        ArrayList<Client> clienti = new ArrayList<>();
        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            Client client= new Client(result);
            clienti.add(client);
        }
        return clienti;

    }
}
