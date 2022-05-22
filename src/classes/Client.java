package classes;

public class Client extends Persoana{
    private static int _id = 1000;
    private final int legitimatie;
    private TipClient tipClient;


    public Client(String nume, String prenume, String email, String nrTelefon, String adresa, String tipClient) {
        super(nume, prenume, email, nrTelefon, adresa);
        this.tipClient = TipClient.valueOf(tipClient);
        this.legitimatie = ++_id;;
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
        System.out.print(this.getPrenume());
        System.out.print(" Email: ");
        System.out.print(this.getEmail());
        System.out.print(" Numar de telefon: ");
        System.out.print(this.getNrTelefon());
        System.out.print(" Adresa: ");
        System.out.print(this.getAdresa());
        System.out.print(" Tip client: ");
        System.out.print(this.getTipClient());
        System.out.print(" Numar legitimatie: ");
        System.out.print(this.getLegitimatie());
        System.out.print(".");
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return getLegitimatie() == client.getLegitimatie();
    }
}
