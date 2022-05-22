import classes.*;
import servicies.*;

import java.util.Scanner;

public class Main {



    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        BibliotecarService bibliotecarService = new BibliotecarService();
        CarteService carteService = new CarteService();
        AutorService autorService = new AutorService();
        CategorieService categorieService = new CategorieService();
        EdituraService edituraService = new EdituraService();
        ClientService clientService = new ClientService();

        System.out.println("Bine ati venit in biblioteca!");

        while (true) {
            System.out.println("Alegeti rolul dumneavoastra: " +
                    "Admin, Bibliotecar, Client");
            String line = s.nextLine();
            switch (line) {
                case "Admin": {
                    while (true) {
                        System.out.println("""
                                1. Adauga bibliotecar
                                2. Afiseaza toti bibliotecarii
                                0. Iesire din program""");
                        System.out.println("Optiune: ");
                        int option = Integer.parseInt(s.nextLine());
                        switch (option) {
                            case 1:
                                try {
                                    System.out.println("Nume:");
                                    String nume = s.nextLine();
                                    System.out.println("Prenume:");
                                    String prenume = s.nextLine();
                                    System.out.println("Email: ");
                                    String email = s.nextLine();
                                    System.out.println("Numar de telefon: ");
                                    String nrTelefon = s.nextLine();
                                    System.out.println("Adresa: ");
                                    String adresa = s.nextLine();
                                    System.out.println("Data angajare:");
                                    String dataAngajare = s.nextLine();
                                    bibliotecarService.adaugaBibliotecar(nume,prenume,email,nrTelefon,adresa,dataAngajare);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("-------------------------");
                                    for(Bibliotecar bib : bibliotecarService.getBibliotecari()){
                                        bib.afisare();
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Nu ati introdus o optiune valida");
                        }
                    }

                }
                case "Client": {
                    while (true) {
                        System.out.println("""
                                1. Afiseaza carti din biblioteca
                                2. Afiseaza carti imprumutate
                                3. Afiseaza carti nereturnate
                                0. Iesire din program""");
                        System.out.println("Optiune: ");
                        int option = Integer.parseInt(s.nextLine());
                        switch (option) {
                            case 1:
                                try {
                                    System.out.println("-------------------------");
                                    for(Carte carte : carteService.getCarti()){
                                        carte.afisare();
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("-------------------------");
                                    for(CarteImprumutata carteImprumutata : carteService.getCartiImprumutate()){
                                        carteImprumutata.afisare();
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    System.out.println("-------------------------");
                                    carteService.cartiNereturnate();
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("Nu ati introdus o optiune valida");
                        }
                    }

                }
                case "Bibliotecar": {
                    while (true) {
                        System.out.println("""
                                1. Adauga client
                                2. Adauga carte
                                3. Imprumuta carte
                                4. Returneaza carte
                                5. Adauga autor
                                6. Adauga editura
                                7. Adauga categorie
                                8. Afiseaza toti clientii din biblioteca
                                9. Afiseaza toate cartile din biblioteca
                                10. Afiseaza carti imprumutate
                                11. Afiseaza carti nereturnate
                                12. Afiseaza toti autorii din biblioteca
                                13. Afiseaza toate editurile din biblioteca
                                14. Afiseaza toate categoriile din biblioteca
                                0. Exit""");
                        System.out.println("Option: ");
                        int option = Integer.parseInt(s.nextLine());
                        switch (option) {
                            case 1:
                                try {
                                    System.out.println("Nume:");
                                    String nume = s.nextLine();
                                    System.out.println("Prenume:");
                                    String prenume = s.nextLine();
                                    System.out.println("Email: ");
                                    String email = s.nextLine();
                                    System.out.println("Numar de telefon: ");
                                    String nrTelefon = s.nextLine();
                                    System.out.println("Adresa: ");
                                    String adresa = s.nextLine();
                                    System.out.println("Tip client:");
                                    String tipClient = s.nextLine();
                                    ClientService.adaugaClient(nume,prenume,email,nrTelefon,adresa, tipClient);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("Titlu:");
                                    String titlu = s.nextLine();
                                    System.out.println("Nume Autor:");
                                    String numeAutor = s.nextLine();
                                    System.out.println("Nume Editura: ");
                                    String numeEditura = s.nextLine();
                                    System.out.println("ISBN: ");
                                    String isbn = s.nextLine();
                                    System.out.println("Nume Categorie: ");
                                    String numeCategorie = s.nextLine();
                                    CarteService.adaugaCarte(titlu,numeAutor,numeEditura,isbn,numeCategorie);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    System.out.println("Numar legitimatie:");
                                    Integer numarLegitimatie = Integer.valueOf(s.nextLine());
                                    System.out.println("Titlu carte:");
                                    String titluCarte = s.nextLine();
                                    CarteService.imprumutaCarte(numarLegitimatie,titluCarte);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 4:
                                try {
                                    System.out.println("Numar legitimatie:");
                                    Integer numarLegitimatie = Integer.valueOf(s.nextLine());
                                    System.out.println("Titlu carte:");
                                    String titluCarte = s.nextLine();
                                    CarteService.returnareCarte(numarLegitimatie,titluCarte);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 5:
                                try {
                                    System.out.println("Nume autor:");
                                    String numeAutor = s.nextLine();
                                    System.out.println("Prenume autor:");
                                    String prenumeAutor = s.nextLine();
                                    System.out.println("Tara: ");
                                    String tara = s.nextLine();
                                    AutorService.adaugaAutor(numeAutor,prenumeAutor,tara);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 6:
                                try {
                                    System.out.println("Nume editura:");
                                    String numeEditura = s.nextLine();
                                    System.out.println("Adresa editura:");
                                    String adresaEditura = s.nextLine();
                                    EdituraService.adaugaEditura(numeEditura,adresaEditura);
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 7:
                                try {
                                    System.out.println("Nume Categorie:");
                                    String numeCategorie = s.nextLine();
                                    System.out.println("Etaj categorie:");
                                    int etaj = Integer.parseInt(s.nextLine());
                                    System.out.println("Raft categorie: ");
                                    int raft = Integer.parseInt(s.nextLine());
                                    CategorieService.adaugaCategorie(numeCategorie, etaj, raft);
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }

                                break;
                            case 8:
                                try {
                                    System.out.println("-------------------------");
                                    for(Client client : ClientService.getClienti()){
                                        client.afisare();
                                        Thread.sleep(2000);
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }

                                break;
                            case 9:
                                try {
                                    System.out.println("-------------------------");
                                    for(Carte carte : carteService.getCarti()){
                                        carte.afisare();
                                        Thread.sleep(2000);
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }

                                break;
                            case 10:
                                try {
                                    System.out.println("-------------------------");
                                    for(CarteImprumutata carteImprumutata : carteService.getCartiImprumutate()){
                                        carteImprumutata.afisare();
                                        Thread.sleep(2000);
                                    }
                                    System.out.println("-------------------------");
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 11:
                                try {
                                    System.out.println("-------------------------");
                                    carteService.cartiNereturnate();
                                    System.out.println("-------------------------");
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 12:
                                try {
                                    System.out.println("-------------------------");
                                    for(Autor autor : autorService.getAutori()){
                                        System.out.println(autor.toString());
                                    }
                                    System.out.println("-------------------------");
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 13:
                                try {
                                    System.out.println("-------------------------");
                                    for(Editura editura : edituraService.getEdituri()){
                                        System.out.println(editura.toString());
                                    }
                                    System.out.println("-------------------------");
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }
                                break;
                            case 14:
                                try {
                                    System.out.println("-------------------------");
                                    for(Categorie categorie : categorieService.getCategorii()){
                                        System.out.println(categorie.toString());
                                    }
                                    System.out.println("-------------------------");
                                    Thread.sleep(2000);
                                }
                                catch (Exception e) {
                                    System.out.println("Eroare: " + e.getMessage());
                                }

                                break;
                            case 0:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                    }
                }
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}