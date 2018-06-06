package domaine;


import javax.annotation.CheckForNull;

public class Sport {
    private int no;
    private String nom;
    
    public Sport(int no, String nom) { this.no=no; this.nom=nom; }
    public Sport(int no) { this(no, ""); }

    public String getNom() { return nom; }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else {
            return this.no != ((Sport) obj).no;
        }

    }
    public String toString() { return nom; }

    public String concatenerString(String ... strings){
        String conca ="";
        for (int i=0;i<strings.length; i++){
            conca += strings[i].toString();
        }
        return conca;
    }
}