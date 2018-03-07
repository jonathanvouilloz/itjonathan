/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import domaine.Athlete;
import domaine.Pays;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModelAthletes;
import metier.ModelPays;

/**
 *
 * @author jeremyfr.maret
 */
public class DetailObserver implements Observer {
    
    private TextField tfNo, tfNom, tfPrenom, tfPays, tfSport;
    
    public DetailObserver(TextField tfNo, TextField tfNom, TextField tfPrenom, TextField tfPays, TextField tfSport) {
        this.tfNo=tfNo; this.tfNom=tfNom; this.tfPrenom=tfPrenom; this.tfPays=tfPays; this.tfSport = tfSport;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.SEL) {
            Athlete a = ((Athlete)((ModelAthletes)o).get());
            tfNo.setText(String.valueOf(a.getNo())); tfNom.setText(a.getNom()); tfPrenom.setText(a.getPrenom()); tfPays.setText(a.getPays().toString()); tfSport.setText(a.getSport().toString());
        } else {
            tfNo.setText(null); tfNom.setText(null); tfPrenom.setText(null); tfPays.setText(null); tfSport.setText(null);
        }
    }
    
}
