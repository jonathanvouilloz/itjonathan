/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import domaine.Pays;
import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModelSport;

/**
 *
 * @author jeremyfr.maret
 */
public class LstSportObserver implements Observer {
    
    private List lst;
    
    public LstSportObserver(List lst) {
        this.lst = lst;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.LOAD) {
            lst.removeAll(); 
            for (int i=0; i < ((ModelSport)o).size(); i++) {
                lst.add(((ModelSport)o).get(i).toString());
            }
        }
    }
    
}
