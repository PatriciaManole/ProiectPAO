package servicies;

import classes.Bibliotecar;

import java.util.ArrayList;

public class BibliotecarService {
    private ArrayList<Bibliotecar> bibliotecari = new ArrayList<Bibliotecar>();

    public void adaugaBibliotecar(String prenume, String nume, String email, String nrTelefon, String adresa, String dataAngajare){
        Bibliotecar bibliotecarNou = new Bibliotecar(nume,prenume,email,nrTelefon,adresa,dataAngajare);
        bibliotecari.add(bibliotecarNou);
    }

    public ArrayList<Bibliotecar> getBibliotecari(){
        return bibliotecari;
    }
}
