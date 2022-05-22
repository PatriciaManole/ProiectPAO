package classes;

public class Bibliotecar extends Persoana{
    private String dataAngajare;

    public Bibliotecar(String nume, String prenume, String email, String nrTelefon, String adresa, String dataAngajare) {
        super(nume, prenume, email, nrTelefon, adresa);
        this.dataAngajare=dataAngajare;

    }

    public String getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(String dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public void afisare(){
        System.out.print("Nume: ");
        System.out.print(this.getNume());
        System.out.print(" ");
        System.out.print(this.getPrenume());
        System.out.print(" Email: ");
        System.out.print(this.getEmail());
        System.out.print(" Numar de telefon: ");
        System.out.print(this.getNrTelefon());
        System.out.print(" Adresa: ");
        System.out.print(this.getAdresa());
        System.out.print(" Data angajare: ");
        System.out.print(this.getDataAngajare());
        System.out.print(".");
    }

    @Override
    public String toString() {
        return super.toString()+","+String.format("%s", getDataAngajare());
    }
}
