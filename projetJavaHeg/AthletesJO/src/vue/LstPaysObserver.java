/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ModelePays;
import metier.Action;

/**
 *
 * @author stephaneTRV
 */
public class LstPaysObserver implements Observer{
    private List lst;

    public LstPaysObserver (List lst) { this.lst = lst; }

    @Override
    public void update (Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.LOAD) {
            lst.removeAll(); for (int i=0; i < ((ModelePays)o).size(); i++) { lst.add(((ModelePays)o).get(i).toString()); }
        }
        /*else  if (((Action)arg).getAction() == Action.SEL) 
        {
            ((ModelePays)o).setPos(ModelePays.NO_POS);
        }*/
    }
    
}
