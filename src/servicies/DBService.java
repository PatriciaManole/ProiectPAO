package servicies;

import classes.*;
import database.main.repository.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DBService {
    private static ArrayList<Autor> autori = new ArrayList<>();
    private static ArrayList<Bibliotecar> bibliotecari = new ArrayList<>();
    private static ArrayList<Carte> carti = new ArrayList<>();
    private static NavigableSet<CarteImprumutata> cartiImprumutate = new TreeSet<>();
    private static ArrayList<Categorie> categorii = new ArrayList<>();
    private static ArrayList<Client> clienti = new ArrayList<>();
    private static ArrayList<Editura> edituri = new ArrayList<>();


    public DBService() {
        try {
            autori= AutorRepository.load();
            categorii= CategorieRepository.load();
            edituri= EdituraRepository.load();
            clienti= ClientRepository.load();
            bibliotecari= BibliotecarRepository.load();
            carti= CarteRepository.load();
            cartiImprumutate= CarteImprumutataRepository.load();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void adaugaAutor(String nume, String prenume, String tara){
        Autor autorNou = new Autor(nume,prenume,tara);
        AutorRepository.adaugaAutor(autorNou);
        autori.add(autorNou);

    }

    public static ArrayList<Autor> getAutori(){
        return autori;
    }

    public void adaugaBibliotecar(String prenume, String nume, String email, String nrTelefon, String adresa, String dataAngajare){
        Bibliotecar bibliotecarNou = new Bibliotecar(nume,prenume,email,nrTelefon,adresa,dataAngajare);
        bibliotecari.add(bibliotecarNou);
        BibliotecarRepository.adaugaBibliotecar(bibliotecarNou);
    }

    public ArrayList<Bibliotecar> getBibliotecari(){
        return bibliotecari;
    }

    public ArrayList<Carte> getCarti(){
        return carti;
    }

    public NavigableSet<CarteImprumutata> getCartiImprumutate(){
        return cartiImprumutate;
    }

    public static void adaugaCarte(String titlu, String numeAutor, String numeEditura, String isbn, String numeCategorie){
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

        if(autor != null && editura != null && categorie != null){
            Carte carteNoua = new Carte(titlu, autor, editura, isbn, categorie);
            carti.add(carteNoua);
            CarteRepository.adaugaCarte(carteNoua);
        }
    }

    public static void imprumutaCarte(Integer legitimatieClient, String titluCarte){
        Carte carte = null;
        Client client = null;

        for(Carte carteActuala: carti){
            if(carteActuala.getTitlu().equals(titluCarte)){
                carte = carteActuala;
            }
        }
        for(Client clientActual: clienti){
            if(clientActual.getLegitimatie().equals(legitimatieClient)){
                client = clientActual;
            }
        }

        if(carte != null && client != null){
            CarteImprumutata carteNoua= new CarteImprumutata(client,carte, LocalDateTime.now());
            cartiImprumutate.add(carteNoua);
            CarteImprumutataRepository.adaugaCarteImprumutata(carteNoua);
        }
    }

    public static void returnareCarte(Integer legitimatieClient, String titluCarte) throws IOException, SQLException {
        CarteImprumutata carteImprumutata = null;
        for (CarteImprumutata carte : cartiImprumutate)
        {
            if(carte.getClient().getLegitimatie().equals(legitimatieClient) &&
                    carte.getCarte().getTitlu().equals(titluCarte)){
                carteImprumutata = carte;}

        }

        if(carteImprumutata != null){
            carteImprumutata.returnare(LocalDateTime.now());
            CarteImprumutataRepository.update(carteImprumutata);
        }

    }


    public void cartiNereturnate(){
        for (CarteImprumutata carte : cartiImprumutate)
        {
            if(!carte.getStatus()){
                System.out.print("\n");
                carte.afisare();
            }
        }

    }

    public static void adaugaCategorie(String nume, Integer etaj, Integer raft){
        Categorie categorieNoua = new Categorie(nume,etaj,raft);
        categorii.add(categorieNoua);
        CategorieRepository.adaugaCategorie(categorieNoua);
    }

    public static ArrayList<Categorie> getCategorii(){
        return categorii;
    }

    public static void adaugaClient(String prenume, String nume, String email, String nrTelefon, String adresa, String tipClient,Integer legitimatie){
        Client ClientNou = new Client(nume,prenume,email,nrTelefon,adresa,tipClient,legitimatie);
        clienti.add(ClientNou);
        ClientRepository.adaugaClient( ClientNou);
    }

    public static ArrayList<Client> getClienti(){
        return clienti;
    }

    public static void adaugaEditura(String nume, String adresa){
        Editura edituraNoua = new Editura(nume,adresa);
        edituri.add(edituraNoua);
        EdituraRepository.adaugaEditura(edituraNoua);
    }

    public static ArrayList<Editura> getEdituri(){
        return edituri;
    }

}
