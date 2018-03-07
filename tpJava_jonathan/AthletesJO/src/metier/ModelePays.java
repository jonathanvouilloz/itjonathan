/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import domaine.Pays;

/**
 *
 * @author Jonathan vouilloz
 */
public class ModelePays extends ListeObjects {
    
    private int paysPos;
    private int skiPos = NO_POS;
    
     public void loadData () {
        aListe = dao.PaysDao.getListePays();
        setChanged(); notifyObservers(new Action(Action.LOAD));
    }
    
    public Object get() {
        return (Pays)super.get();
    }    
    
    public Object get(int i) {
        return (Pays)super.get(i);
    }
    
    public void showSkieurs(int ind) {
        paysPos = ind;
        setChanged();
        notifyObservers(new Action(Action.SEL, NO_POS));
    }

    public void showSkieur(int ind) {
        skiPos = ind;
        setChanged();
        notifyObservers(new Action(Action.SEL, skiPos));
    }
}
