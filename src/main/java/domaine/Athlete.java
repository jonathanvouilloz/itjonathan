package domaine;

import javax.annotation.CheckForNull;

public class Athlete {
    private int no;
    private String prenom;
    private String nom;
    private Pays pays;
    private Sport sport;
<<<<<<< HEAD
    
    public Athlete(int no, String prenom, String nom, Pays pays, Sport sport) { this.no=no; this.prenom=prenom; this.nom=nom; this.pays=pays; this.sport=sport; }
    
    public boolean equals(Object obj) { return this.no == ((Athlete)obj).no; }
=======

    public Athlete(int no, String prenom, String nom, Pays pays, Sport sport) {
        this.no = no;
        this.prenom = prenom;
        this.nom = nom;
        this.pays = pays;
        this.sport = sport;
    }

    public int getNo() {
        return no;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Pays getPays() {
        return pays;
    }

    public Sport getSport() {
        return sport;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else {
            return this.no != ((Athlete) obj).no;
        }
    }

>>>>>>> 019510ec7f1c527aa8eb428bc8a2680877014c2b
    public String toString() { return prenom+" "+nom; }
}