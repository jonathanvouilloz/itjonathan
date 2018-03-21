package domaine;

public class Sport {
    private int no;
    private String nom, categorie;
    
    public Sport(int no, String nom, String categorie) { this.no=no; this.nom=nom; this.categorie=categorie }
    public Sport(int no) { this(no, ""); }
    
    public int getNo() { return no; }
    public String getCategorie() { return categorie; }
    
    public boolean equals(Object obj) { return this.no == ((Sport)obj).no; }
    public String toString() { return nom; }
}