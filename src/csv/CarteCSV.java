package csv;

import classes.Autor;
import classes.Carte;
import classes.Categorie;
import classes.Editura;
import servicies.AutorService;
import servicies.CategorieService;
import servicies.EdituraService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static servicies.CarteService.adaugaCarte;

public class CarteCSV  implements  TamplateCSV<Carte> {
    private static final CarteCSV INSTANCE = new CarteCSV();

    private final String auditPath = "./files/audit.csv";

    private CarteCSV() {
    }

    @Override
    public ArrayList<Carte> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Carte> carti = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                ArrayList<Autor> autori= new ArrayList<>();
                ArrayList<Editura> edituri= new ArrayList<>();
                ArrayList<Categorie> categorii= new ArrayList<>();

                autori.addAll(AutorCSV.getInstance().load( "files/autori.csv"));
                edituri.addAll(EdituraCSV.getInstance().load( "files/edituri.csv"));
                categorii.addAll(CategorieCSV.getInstance().load( "files/categorii.csv"));
                Autor autor = null;
                Editura editura = null;
                Categorie categorie = null;

                for(Autor a:autori){
                    if(a.getNume().equals(data[1])){
                        autor = a;
                    }
                }

                for(Editura e : edituri){
                    if(e.getNume().equals(data[2])){
                        editura = e;
                    }
                }

                for(Categorie c: categorii){
                    if(c.getNume().equals(data[4])){
                        categorie = c;
                    }
                }

                Carte carte = new Carte(data[0], autor, editura, data[3], categorie);
                carti.add(carte);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_cartii");
        return carti;
    }

    @Override
    public void add(String fileName, Carte content) {
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
        audit(auditPath, "add_carti");
    }

    public static CarteCSV getInstance() {
        return INSTANCE;
    }
}
