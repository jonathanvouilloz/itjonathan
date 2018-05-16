package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListeAthletes;
import metier.Action;
import metier.ListeSports;

public class ObsPourLstAthletes implements Observer {
    private List lst;

    public ObsPourLstAthletes (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        ListeAthletes listeAthletes = (ListeAthletes)o;
        switch (((Action)arg).getAction()) {
            case Action.LOAD: fillList(listeAthletes); break;
        }
    }

    private void fillList(ListeAthletes listeAthletes){
        int size = listeAthletes.size();
        lst.removeAll();
        for (int i = 0; i < size; i++) {
            lst.add(listeAthletes.getAthlete(i).toString());
        }
    }
}