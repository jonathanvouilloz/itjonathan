/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import domaine.Athlete;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModeleAthletes;


/**
 *
 * @author stephaneTRV
 */
public class DetailsAthletesObserver  implements Observer{
    private TextField no,prenom,nom,pays,sport;

    public DetailsAthletesObserver (TextField no,TextField nom, TextField prenom, TextField pays, TextField sport) { this.no = no; this.nom = nom; this.prenom = prenom;this.pays = pays; this.sport = sport;}
       
    @Override 
    public void update (Observable o, Object arg) {
         if (((Action)arg).getAction() == Action.SEL) {
            Athlete a = ((Athlete)((ModeleAthletes)o).get());
            no.setText(String.valueOf(a.getNo()));
            nom.setText(a.getNom());
            prenom.setText(a.getPrenom());
            pays.setText(a.getPays().toString());
            sport.setText(a.getSport().toString());
        } 
        // Peut mieux faire possiblement faire une action DEL mais est-ce necessaire pour notre cas ?  
        else {
            no.setText("");
            nom.setText("");
            prenom.setText("");
            pays.setText("");
            sport.setText("");
        }
    }
}
