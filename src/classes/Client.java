package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client extends Persoana{
    private final int legitimatie;
    private TipClient tipClient;


    public Client(String nume, String prenume, String email, String nrTelefon, String adresa, String tipClient, int legitimatie) {
        super(nume, prenume, email, nrTelefon, adresa);
        this.tipClient = TipClient.valueOf(tipClient);
        this.legitimatie = legitimatie;
    }

    public Client(ResultSet result) throws SQLException {
        super(result);
        this.legitimatie=result.getInt("Legitimatie");
        this.tipClient=TipClient.valueOf(result.getString("TipClient"));
    }


    public TipClient getTipClient() {
        return tipClient;
    }

    public Integer getLegitimatie() {
        return legitimatie;
    }

    public void setTipClient(TipClient tipClient) {
        this.tipClient = tipClient;
    }




    @Override
    public String toString() {
        return super.toString()+","+String.format("%s", getTipClient())+","+String.format("%s", getLegitimatie());
    }

    public void afisare(){
        System.out.print("Nume: ");
        System.out.print(this.getNume());
        System.out.print(" ");
        System.out.println(this.getPrenume());
        System.out.print("Email: ");
        System.out.println(this.getEmail());
        System.out.print("Numar de telefon: ");
        System.out.println(this.getNrTelefon());
        System.out.print("Adresa: ");
        System.out.println(this.getAdresa());
        System.out.print("Tip client: ");
        System.out.println(this.getTipClient());
        System.out.print("Numar legitimatie: ");
        System.out.println(this.getLegitimatie());
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return getLegitimatie() == client.getLegitimatie();
    }
}
