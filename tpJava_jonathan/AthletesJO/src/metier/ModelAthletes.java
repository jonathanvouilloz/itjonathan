package metier;

import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author jeremyfr.maret
 */
public class ModelAthletes extends ListeObjects{    
    
    public void loadData(Pays p, Sport s) {
        aListe = dao.AthleteDao.getListeAthletes(p, s);
        setChanged(); notifyObservers(new Action(Action.LOAD, NO_POS));
    }

    public Object get() {
        return (Athlete)super.get();
    }
    
    public Object get(int i) {
        return (Athlete)super.get(i);
    }
    
}
