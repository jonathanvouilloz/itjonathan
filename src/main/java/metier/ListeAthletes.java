package metier;

import dao.AthleteDao;
import dao.FileReader;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.Observer;

public class ListeAthletes extends ListeObjects {

    public void chargerDonnee(Pays pays, Sport sport){
        FileReader fileReader = new FileReader();
        AthleteDao athleteDao = new AthleteDao(fileReader);
        aListe = athleteDao.getListeAthletes(pays,sport);
        setChanged();notifyObservers(new Action(Action.LOAD));
    }


    public Athlete getAthlete() { return (Athlete)super.get(); }
    public Athlete getAthlete(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Athlete)super.get(pos); }
}