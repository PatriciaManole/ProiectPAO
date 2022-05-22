package csv;

import classes.Categorie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CategorieCSV  implements  TamplateCSV<Categorie> {
    private static final CategorieCSV INSTANCE = new CategorieCSV();

    private final String auditPath = "./files/audit.csv";

    private CategorieCSV() {
    }

    @Override
    public ArrayList<Categorie> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Categorie> categorii = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Categorie categorie = new Categorie(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                categorii.add(categorie);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_categorii");
        return categorii;
    }

    @Override
    public void add(String fileName, Categorie content) {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(fileName, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            csvWriter.append(content.toString());
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add_categorii");
    }

    public static CategorieCSV getInstance() {
        return INSTANCE;
    }
}
