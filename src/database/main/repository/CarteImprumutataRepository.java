package database.main.repository;

import classes.*;
import database.main.config.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CarteImprumutataRepository {
    public static NavigableSet<CarteImprumutata> load() throws SQLException {
        String query = "select * from carteimprumutata";
        NavigableSet<CarteImprumutata> cartiImprumutate = new TreeSet<>();
        ArrayList<Carte> carti =  CarteRepository.load();
        ArrayList<Client> clienti =  ClientRepository.load();

        Statement statement= DbConnection.getInstance().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            String status = result.getString("status");
            String numeClient = result.getString("LegitimatieClient");
            String titluCarte = result.getString("TitluCarte");
            String dataimprumut = result.getString("DataImprumut");
            String datareturnare = result.getString("DataReturnare");

            Carte carte = null;
            Client client = null;

            for(Carte c:carti){
                if(c.getTitlu().equals(titluCarte)){
                    carte = c;
                }
            }

            for(Client cl : clienti){
                if(cl.getNume().equals(numeClient)){
                    client = cl;
                }
            }

            CarteImprumutata carteImprumutata = new CarteImprumutata(Boolean.parseBoolean(status), client, carte, LocalDateTime.parse(dataimprumut), LocalDateTime.parse(datareturnare));
            cartiImprumutate.add(carteImprumutata);

        }
        return cartiImprumutate;
    }

    public static void adaugaCarteImprumutata(CarteImprumutata carteImprumutata){
        String query = "insert into carteimprumutata values ( false, ?, ?, ?, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setInt(1, carteImprumutata.getClient().getLegitimatie());
            statement.setString(2, carteImprumutata.getCarte().getTitlu());
            statement.setString(3, carteImprumutata.getDataImprumutare().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            statement.setString(4, carteImprumutata.getDataImprumutare().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void update(CarteImprumutata carteImprumutata) throws SQLException {
        String query = "update carteimprumutata set DataReturnare = ? where Titlucarte = ? and LegitimatieClient = ?";

        PreparedStatement statement = DbConnection.getInstance().prepareStatement(query);
        statement.setString(1, carteImprumutata.getDataReturnare().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        statement.setString(2, carteImprumutata.getCarte().getTitlu());
        statement.setInt(3, carteImprumutata.getClient().getLegitimatie());
        statement.executeUpdate();

    }
}
