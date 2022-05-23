package servicies;

import classes.Autor;
import csv.AutorCSV;

import java.util.ArrayList;

public class AutorService {
    private static ArrayList<Autor> autori = new ArrayList<>();
    private static final AutorCSV autorCSV = AutorCSV.getInstance();
    private static final String autorCSVPath = "files/autori.csv";

    public AutorService() {
        try {
            autori.addAll(autorCSV.load(autorCSVPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void adaugaAutor(String nume, String prenume, String tara){
        Autor autorNou = new Autor(nume,prenume,tara);
        autori.add(autorNou);
        autorCSV.add(autorCSVPath, autorNou);
    }

    public static ArrayList<Autor> getAutori(){
        return autori;
    }
}
