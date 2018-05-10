package metier;

import dao.AthleteDao;
import dao.FileReader;
import dao.SportDao;
import domaine.Pays;
import domaine.Sport;
import java.util.Observer;

public class ListeSports extends ListeObjects {


    public void chargerDonnee(){
        FileReader fileReader = new FileReader();
        SportDao sportDao = new SportDao(fileReader);
        aListe = sportDao.getListeSports();
        setChanged();notifyObservers(new Action(Action.LOAD));
    }
    
    public Sport getSport() { return (Sport)super.get(); }
    public Sport getSport(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return (Sport)super.get(pos);
    }
}