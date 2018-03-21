/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

/**
 *
 * @author stephaneTRV
 */
public class ModeleAthletes extends ListeObjects {
    
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
