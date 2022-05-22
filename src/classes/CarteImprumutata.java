package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CarteImprumutata implements Comparable<CarteImprumutata>{
    private Boolean status; // true daca cartea a fost returnata false altfel
    private Client client;
    private Carte carte;
    private LocalDateTime dataImprumutare;
    private LocalDateTime dataReturnare;

    public CarteImprumutata(Client client, Carte carte, LocalDateTime dataImprumutare) {
        this.status = false;
        this.client = client;
        this.carte = carte;
        this.dataImprumutare = dataImprumutare;
        this.dataReturnare = dataImprumutare;
    }
    public CarteImprumutata(Boolean status,Client client, Carte carte, LocalDateTime dataImprumutare, LocalDateTime dataReturnare){
        this.status = status;
        this.client = client;
        this.carte = carte;
        this.dataImprumutare = dataImprumutare;
        this.dataReturnare = dataReturnare;
    }



    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public LocalDateTime getDataImprumutare() {
        return dataImprumutare;
    }

    public void setDataImprumutare(LocalDateTime dataImprumutare) {
        this.dataImprumutare = dataImprumutare;
    }

    public LocalDateTime getDataReturnare() {
        return dataReturnare;
    }

    public void setDataReturnare(LocalDateTime dataReturnare) {
        this.dataReturnare = dataReturnare;
    }


    public int compareTo(CarteImprumutata other) {
        return this.dataImprumutare.compareTo(other.getDataImprumutare());
    }

    public void returnare(LocalDateTime dataReturnare){
        this.status = true;
        this.dataReturnare = dataReturnare;
    }

    public void afisare(){
        System.out.print("Cartea ");
        System.out.print(this.carte.getTitlu());
        System.out.print(" a fost imprumutata de ");
        System.out.print(this.client.getNume());
        System.out.print(" ");
        System.out.print(this.client.getPrenume());
        System.out.print(" la data de ");
        System.out.print(this.dataImprumutare.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.print(".\n");
    }

    @Override
    public String toString() {
        return  String.format("%s,%s,%s",getStatus(),getClient().getLegitimatie(),getCarte().getTitlu()) +  "," + String.format("%s,%s", getDataImprumutare(),getDataReturnare()) ;
    }
}


