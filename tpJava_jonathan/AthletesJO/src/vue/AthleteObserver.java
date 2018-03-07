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
import metier.ModeleAthlete;

/**
 *
 * @author Jonathan vouilloz
 */
public class AthleteObserver implements Observer {
    private List list;
    
    public AthleteObserver(List list) {
        this.list = list;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.LOAD) {
            list.removeAll(); 
            for (int i=0; i < ((ModeleAthlete)o).size(); i++) {
                list.add(((ModeleAthlete)o).get(i).toString());
            }
        } else if (((Action)arg).getAction() == Action.SEL) {
            
        }
    }
}
