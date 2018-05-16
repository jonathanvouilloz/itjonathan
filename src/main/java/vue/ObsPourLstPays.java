package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListePays;
import metier.Action;

public class ObsPourLstPays implements Observer {
    private List lst;

    public ObsPourLstPays (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        ListePays listePays = (ListePays)o;
        switch (((Action)arg).getAction()) {
            case Action.LOAD: fillList(listePays); break;
        }
    }

    private void fillList(ListePays listePays){
        int size = listePays.size();
        lst.removeAll();
        for (int i = 0; i < size; i++) {
            lst.add(listePays.getPays(i).toString());
        }
    }

}