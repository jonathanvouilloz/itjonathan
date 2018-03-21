/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.PaysDao;
import domaine.Pays;
import java.util.ArrayList;

/**
 *
 * @author stephaneTRV
 */
public class ModelePays extends ListeObjects {
    
    public void loadData(){
        aListe = PaysDao.getListePays();
        setChanged();
        notifyObservers(new Action(Action.LOAD));
    }
    
    
    @Override
    public Object get(){
            return (Pays)super.get();
    }
    
    @Override
    public Object get(int pos){
            return (Pays)super.get(pos);
    }
}
