package csv;

import classes.*;
import servicies.AutorService;
import servicies.CategorieService;
import servicies.ClientService;
import servicies.EdituraService;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class CarteImprumutataCSV  implements  TamplateCSV<CarteImprumutata> {
    private static final CarteImprumutataCSV INSTANCE = new CarteImprumutataCSV();

    private final String auditPath = "./files/audit.csv";

    private CarteImprumutataCSV() {
    }

    @Override
    public ArrayList<CarteImprumutata> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<CarteImprumutata> cartiImprumutate = new ArrayList<>();
        try {
            String line = csvReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                ArrayList<Carte> carti= new ArrayList<>();
                ArrayList<Client> clienti= new ArrayList<>();

                carti.addAll(CarteCSV.getInstance().load( "files/carti.csv"));
                clienti.addAll(ClientCSV.getInstance().load( "files/clienti.csv"));

                Carte carte = null;
                Client client = null;

                for(Carte carteActuala: carti){
                    if(carteActuala.getTitlu().equals(data[2])){
                        carte = carteActuala;
                    }
                }
                for(Client clientActual: clienti){
                    if(clientActual.getLegitimatie().equals(Integer.parseInt(data[1]))){
                        client = clientActual;
                    }
                }

                CarteImprumutata carteImprumutata = new CarteImprumutata(Boolean.parseBoolean(data[0]) ,client, carte, LocalDateTime.parse(data[3]), LocalDateTime.parse(data[4]));
                cartiImprumutate.add(carteImprumutata);

                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "load_cartiImprumutate");
        return cartiImprumutate;
    }

    @Override
    public void add(String fileName, CarteImprumutata content) {
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
        audit(auditPath, "add_cartiImprumutate");
    }

    public void edit(String fileName, CarteImprumutata content) throws IOException {
            Scanner sc = new Scanner(new File(fileName));
            StringBuffer buffer = new StringBuffer();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();
            String oldLine = String.format("false,%s,%s",content.getClient().getLegitimatie(),content.getCarte().getTitlu()) + "," + String.format("%s,%s", content.getDataImprumutare(),content.getDataImprumutare());
            System.out.println(oldLine);
            String newLine = content.toString();
            System.out.println(newLine);

            fileContents = fileContents.replaceAll(oldLine, newLine);
            FileWriter writer = new FileWriter(fileName);
            writer.append(fileContents);
            writer.flush();

        audit(auditPath, "edit_cartiImprumutate");
    }
    public static CarteImprumutataCSV getInstance() {
        return INSTANCE;
    }
}
