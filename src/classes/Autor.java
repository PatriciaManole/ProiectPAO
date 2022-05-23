package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Autor {
    private String nume;
    private String prenume;
    private String tara;

    public Autor(String nume, String prenume, String tara){
        this.nume=nume;
        this.prenume=prenume;
        this.tara=tara;
    }
    public Autor(ResultSet result) throws SQLException {
        this.nume=result.getString("Nume");
        this.prenume=result.getString("Prenume");
        this.tara=result.getString("Tara");
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", getNume(), getPrenume(), getTara());
    }
}
