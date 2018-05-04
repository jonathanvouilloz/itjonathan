package metier;

import dao.FileReader;
import dao.PaysDao;
import domaine.Pays;
import java.util.Observer;

public class ListePays extends ListeObjects {
    
 
    public ListePays(Observer observer) {
        super(observer);
        FileReader r = new FileReader();
        PaysDao paysD = new PaysDao(r);
        aListe = paysD.getListePays();
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    public Pays getPays() { return (Pays)super.get(); }
    public Pays getPays(int pos) { return (Pays)super.get(pos); }
}