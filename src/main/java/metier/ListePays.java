package metier;

import dao.FileReader;
import dao.PaysDao;
import domaine.Pays;
import java.util.Observer;

public class ListePays extends ListeObjects {


    private PaysDao pays = new PaysDao(new FileReader());

    public ListePays(Observer observer) {
        super(observer);
        aListe = pays.getListePays();
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    public Pays getPays() { return (Pays)super.get(); }
    public Pays getPays(int pos) { return (Pays)super.get(pos); }
}