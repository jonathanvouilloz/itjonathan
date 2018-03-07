/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModelAthletes;

/**
 *
 * @author jeremyfr.maret
 */
public class LstAthletesObserver implements Observer {
    
    private List lst;
    
    public LstAthletesObserver(List lst) {
        this.lst = lst;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.LOAD) {
            lst.removeAll(); 
            for (int i=0; i < ((ModelAthletes)o).size(); i++) {
                lst.add(((ModelAthletes)o).get(i).toString());
            }
        } else if (((Action)arg).getAction() == Action.SEL) {
            
        }
    }
    
}
