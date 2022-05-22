package csv;

import classes.Editura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class EdituraCSV  implements  TamplateCSV<Editura> {
    private static final EdituraCSV INSTANCE = new EdituraCSV();

    private final String auditPath = "./files/audit.csv";

    private EdituraCSV() {
    }

    @Override
    public ArrayList<Editura> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Editura> edituri = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Editura Editura = new Editura(data[0], data[1]);
                edituri.add(Editura);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_edituri");
        return edituri;
    }

    @Override
    public void add(String fileName, Editura content) {
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
        audit(auditPath, "add_edituri");
    }

    public static EdituraCSV getInstance() {
        return INSTANCE;
    }
}
