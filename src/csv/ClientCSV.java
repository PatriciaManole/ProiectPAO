package csv;

import classes.Client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ClientCSV  implements  TamplateCSV<Client> {
    private static final ClientCSV INSTANCE = new ClientCSV();

    private final String auditPath = "./files/audit.csv";

    private ClientCSV() {
    }

    @Override
    public ArrayList<Client> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Client> clienti = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Client client = new Client(data[0], data[1], data[2], data[3], data[4], data[5],Integer.parseInt(data[6]));
                clienti.add(client);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_clienti");
        return clienti;
    }

    @Override
    public void add(String fileName, Client content) {
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
        audit(auditPath, "add_clienti");
    }

    public static ClientCSV getInstance() {
        return INSTANCE;
    }
}
