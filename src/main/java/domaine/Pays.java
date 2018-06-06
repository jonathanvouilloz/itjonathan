package domaine;

public class Pays {
    private int no;
    private String code;
    private String nom;

    public Pays(int no, String code, String nom) {
        this.no=no; this.code=code; this.nom=nom;
    }
    public Pays(int no) { this(no, "", ""); }


    public boolean equals(Object obj) { return this.no == ((Pays)obj).no; }
    public String toString() { return nom; }
}