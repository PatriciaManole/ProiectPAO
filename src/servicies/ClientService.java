package servicies;

import classes.Client;
import csv.ClientCSV;

import java.util.ArrayList;

public class ClientService {
    private static ArrayList<Client> clienti = new ArrayList<Client>();
    private static final ClientCSV clientCSV = ClientCSV.getInstance();
    private static final String clientCSVPath = "files/clienti.csv";

    public ClientService() {
        try {
            clienti.addAll(clientCSV.load(clientCSVPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void adaugaClient(String prenume, String nume, String email, String nrTelefon, String adresa, String tipClient,Integer legitimatie){
        Client ClientNou = new Client(nume,prenume,email,nrTelefon,adresa,tipClient,legitimatie);
        clienti.add(ClientNou);
        clientCSV.add(clientCSVPath, ClientNou);
    }

    public static ArrayList<Client> getClienti(){
        return clienti;
    }
}
