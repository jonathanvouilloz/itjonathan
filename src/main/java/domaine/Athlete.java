package domaine;

import javax.annotation.CheckForNull;

public class Athlete {
    private int no;
    private String prenom;
    private String nom;
    private Pays pays;
    private Sport sport;

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

    @CheckForNull
    public boolean equals(Object obj) {
        if (obj != null) {
            return this.no == ((Athlete) obj).no;
        }
        return false;
    }

    public String toString() { return prenom+" "+nom; }
}