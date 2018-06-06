package metier;

import dao.FileReader;
import dao.PaysDao;
import domaine.Pays;

import java.util.List;
import java.util.Observer;

public class ListePays extends ListeObjects {



    public void chargerDonnee(){
        FileReader fileReader = new FileReader();
        PaysDao paysDao = new PaysDao(fileReader);
        aListe = paysDao.getListePays();
        setChanged();notifyObservers(new Action(Action.LOAD));
    }

    public Pays getPays() { return (Pays)super.get(); }

    public Pays getPays(int pos) {
        if (pos < 0 || pos >= aListe.size()) {
            return null;
        }
        return (Pays)super.get(pos);
    }

    public List getList(){
        return aListe;
    }
}