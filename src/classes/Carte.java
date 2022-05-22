package classes;

public class Carte {
    private String titlu;
    private Autor autor;
    private Editura editura;
    private String isbn;
    private Categorie categorie;

    public Carte(String titlu, Autor autor, Editura editura, String isbn, Categorie categorie){
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.isbn = isbn;
        this.categorie = categorie;
    }


    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void afisare(){
        System.out.print("Titlu: ");
        System.out.print(this.getTitlu());
        System.out.print(" Autor: ");
        System.out.print(this.getAutor().getNume());
        System.out.print(" ");
        System.out.print(this.getAutor().getPrenume());
        System.out.print(" Editura: ");
        System.out.print(this.getEditura().getNume());
        System.out.print(" ISBN: ");
        System.out.print(this.getIsbn());
        System.out.print(" Categorie: ");
        System.out.print(this.getCategorie().getNume());
        System.out.print(".");
    }

    @Override
    public String toString() {
        return String.format("%s", getTitlu()) + "," + String.format("%s", autor.getNume())+ "," + String.format("%s", editura.getNume())+ "," + String.format("%s", getIsbn()) + "," + String.format("%s", categorie.getNume());
    }
}