package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Persoana {

    private String nume;
    private String prenume;
    private String email;
    private String nrTelefon;
    private String adresa;

    public Persoana(String nume, String prenume, String email, String nrTelefon, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nrTelefon = nrTelefon;
        this.adresa = adresa;
    }

    public Persoana(ResultSet result) throws SQLException {
        this.nume = result.getString("Nume");
        this.prenume = result.getString("Prenume");
        this.email = result.getString("Email");
        this.nrTelefon = result.getString("NumarTelefon");
        this.adresa = result.getString("Adresa");
    }


    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", getNume(), getPrenume(), getEmail(), getNrTelefon(), getAdresa());
    }




}
