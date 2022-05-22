package classes;

import java.time.LocalDateTime;

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
        this.dataReturnare = null;
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
        return this.carte.getTitlu().compareTo(other.carte.getTitlu());
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
        System.out.print(this.dataImprumutare);
        System.out.print(".");
    }

    @Override
    public String toString() {
        return String.format("%s", getStatus()) + "," + client.toString()+ "," + carte.toString()+ "," + String.format("%s", getDataImprumutare()) + "," + String.format("%s", getDataReturnare());
    }
}
