package metier;

import domaine.Pays;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author jeremyfr.maret
 */
public class ModelPays extends ListeObjects{
    
    private int paysPos;
    private static int NO_POS = -1;
    private int skiPos = NO_POS;
    public final int SKI = 0, PAYS = 1;
    
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
        //aLstSkieurs = dao.SkieurDao.getListeSkieurs((Pays)this.getPays(paysPos));
        setChanged(); notifyObservers(new Action(Action.SEL, NO_POS));
    }

    public void showSkieur(int ind) {
        skiPos = ind;
        setChanged(); notifyObservers(new Action(Action.SEL, skiPos));
    }
    
}
