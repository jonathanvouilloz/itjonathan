package metier;

import dao.AthleteDao;
import dao.FileReader;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.Observer;

public class ListeAthletes extends ListeObjects {
    private Pays pays;
    private Sport sport;

    public ListeAthletes(Observer observer) {
        super(observer);
   }

    private AthleteDao athleteDao = new AthleteDao(new FileReader());

    public void charger(Pays p, Sport s) {
        super.aListe = athleteDao.getListeAthletes(pays, sport);
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    public Athlete getAthlete() { return (Athlete)super.get(); }
    public Athlete getAthlete(int pos) { return (Athlete)super.get(pos); }
}