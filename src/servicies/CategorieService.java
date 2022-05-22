package servicies;

import classes.Categorie;
import csv.CategorieCSV;

import java.util.ArrayList;

public class CategorieService {
    private static ArrayList<Categorie> categorii = new ArrayList<Categorie>();
    private static final CategorieCSV categorieCSV = CategorieCSV.getInstance();
    private static final String categorieCSVPath = "files/categorii.csv";

    public CategorieService() {
        try {
            categorii.addAll(categorieCSV.load(categorieCSVPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void adaugaCategorie(String nume, Integer etaj, Integer raft){
        Categorie categorieNoua = new Categorie(nume,etaj,raft);
        categorii.add(categorieNoua);
        categorieCSV.add(categorieCSVPath,categorieNoua);
    }

    public static ArrayList<Categorie> getCategorii(){
        return categorii;
    }
}
