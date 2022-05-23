package servicies;

import classes.Editura;
import csv.EdituraCSV;

import java.util.ArrayList;

public class EdituraService {
    private static ArrayList<Editura> edituri = new ArrayList<>();
    private static final EdituraCSV edituraCSV = EdituraCSV.getInstance();
    private static final String edituraCSVPath = "files/edituri.csv";

    public EdituraService() {
        try {
            edituri.addAll(edituraCSV.load(edituraCSVPath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void adaugaEditura(String nume, String adresa){
        Editura edituraNoua = new Editura(nume,adresa);
        edituri.add(edituraNoua);
        edituraCSV.add(edituraCSVPath,edituraNoua);
    }

    public static ArrayList<Editura> getEdituri(){
        return edituri;
    }
}
