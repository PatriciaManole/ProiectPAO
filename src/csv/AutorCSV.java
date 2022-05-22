package csv;

import classes.Autor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AutorCSV  implements  TamplateCSV<Autor> {
    private static final AutorCSV INSTANCE = new AutorCSV();

    private final String auditPath = "./files/audit.csv";

    private AutorCSV() {
    }

    @Override
    public ArrayList<Autor> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Autor> autori = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Autor autor = new Autor(data[0], data[1], data[2]);
                autori.add(autor);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_autori");
        return autori;
    }

    @Override
    public void add(String fileName, Autor content) {
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
        audit(auditPath, "add_autori");
    }

    public static AutorCSV getInstance() {
        return INSTANCE;
    }
}
