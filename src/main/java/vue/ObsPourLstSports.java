package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListeSports;
import metier.Action;

public class ObsPourLstSports implements Observer {
    private List lst;

    public ObsPourLstSports (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        ListeSports listeSports = (ListeSports)o;
        switch (((Action)arg).getAction()) {
            case Action.LOAD: fillList(listeSports); break;
        }
    }

    private void fillList(ListeSports listeSports){
        int size = listeSports.size();
        lst.removeAll();
        for (int i = 0; i < size; i++) {
            lst.add(listeSports.getSport(i).toString());
        }
    }
}