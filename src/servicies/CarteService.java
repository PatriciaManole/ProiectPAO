package servicies;

import classes.*;
import csv.CarteCSV;
import csv.CarteImprumutataCSV;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class CarteService {
    private static ArrayList<Carte> carti = new ArrayList<>();
    private static NavigableSet<CarteImprumutata> cartiImprumutate = new TreeSet<>();

    private static final CarteCSV carteCSV = CarteCSV.getInstance();
    private static final String carteCSVPath = "files/carti.csv";
    private static final CarteImprumutataCSV carteImprumutataCSV = CarteImprumutataCSV.getInstance();
    private static final String carteImprumutataCSVPath = "files/cartiImprumutate.csv";
    public CarteService() {
        try {
            carti.addAll(carteCSV.load(carteCSVPath));
            cartiImprumutate.addAll(carteImprumutataCSV.load(carteImprumutataCSVPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Carte> getCarti(){
        return carti;
    }

    public NavigableSet<CarteImprumutata> getCartiImprumutate(){
        return cartiImprumutate;
    }

    public static void adaugaCarte(String titlu, String numeAutor, String numeEditura, String isbn, String numeCategorie){
        ArrayList<Autor> autori= AutorService.getAutori();
        ArrayList<Editura> edituri= EdituraService.getEdituri();
        ArrayList<Categorie> categorii= CategorieService.getCategorii();

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
            carteCSV.add(carteCSVPath,carteNoua);
        }
    }

    public static void imprumutaCarte(Integer legitimatieClient, String titluCarte){
        Carte carte = null;
        Client client = null;
        ArrayList<Client> clienti= ClientService.getClienti();
        
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
            CarteImprumutata carteNoua= new CarteImprumutata(client,carte,LocalDateTime.now());
            cartiImprumutate.add(carteNoua);
            carteImprumutataCSV.add(carteImprumutataCSVPath,carteNoua);
        }
    }

    public static void returnareCarte(Integer legitimatieClient, String titluCarte) throws IOException {
        CarteImprumutata carteImprumutata = null;
        for (CarteImprumutata carte : cartiImprumutate)
        {
            if(carte.getClient().getLegitimatie().equals(legitimatieClient) &&
                        carte.getCarte().getTitlu().equals(titluCarte)){
                carteImprumutata = carte;}

        }

        if(carteImprumutata != null){
            carteImprumutata.returnare(LocalDateTime.now());
            carteImprumutataCSV.edit(carteImprumutataCSVPath,carteImprumutata);
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

}
