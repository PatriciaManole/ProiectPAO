package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Editura {
    private String nume;
    private String adresa;

    public Editura(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public Editura(ResultSet result) throws SQLException {
        this.nume=result.getString("Nume");
        this.adresa=result.getString("Adresa");
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", getNume(), getAdresa());
    }
}
