package classes;


public class Categorie {
    private String nume;
    private Integer etaj;
    private Integer raft;

    public Categorie(String nume, Integer etaj, Integer raft){
        this.nume = nume;
        this.etaj = etaj;
        this.raft = raft;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getEtaj() {
        return etaj;
    }

    public void setEtaj(Integer etaj) {
        this.etaj = etaj;
    }

    public Integer getraft() {
        return raft;
    }

    public void setraft(Integer raft) {
        this.raft = raft;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", getNume(), getEtaj(), getraft());
    }
}

