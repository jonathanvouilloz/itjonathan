package domaine;

import javax.annotation.CheckForNull;

public class Pays {
    private int no;
    private String code;
    private String nom;

    public Pays(int no, String code, String nom) {
        this.no=no; this.code=code; this.nom=nom;
    }
    public Pays(int no) { this(no, "", ""); }

    public int getNo() { return no; }
    public String getCode() { return code; }
    public String getNom() { return nom; }

    @CheckForNull
    public boolean equals(Object obj) {
        if (obj != null) {
            return this.no == ((Pays) obj).no;
        }
        return false;
    }
    public String toString() { return nom; }
}