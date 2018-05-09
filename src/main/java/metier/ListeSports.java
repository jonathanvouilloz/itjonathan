package metier;

import dao.FileReader;
import dao.SportDao;
import domaine.Sport;
import java.util.Observer;

public class ListeSports extends ListeObjects {

    public ListeSports(Observer observer){
        super(observer);
        FileReader r = new FileReader();
        SportDao sp = new SportDao(r);
        aListe = sp.getListeSports();
        setChanged();
        notifyObservers(new Action(Action.LOAD));
    }       
    
    public Sport getSport() { return (Sport)super.get(); }
    public Sport getSport(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Sport)super.get(pos);
    }
}