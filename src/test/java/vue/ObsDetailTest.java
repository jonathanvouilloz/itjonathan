package vue;

import domaine.Pays;
import domaine.Sport;
import javafx.beans.Observable;
import metier.Action;
import metier.ListeAthletes;
import metier.ListePays;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ObsDetailTest {

    private ObsPourDetail observer;
    private TextField tfNo, tfPrenom, tfNom, tfNatio, tfSport;
    private Action action;
    private ListeAthletes listAthletes;
    private Pays pays;
    private Sport sport;

    @BeforeTest
    protected void setUp() {
        tfNo = new TextField();
        tfPrenom = new TextField();
        tfNom = new TextField();
        tfNatio = new TextField();
        tfSport = new TextField();
        pays = new Pays(34, "CAN", "Canada");
        sport = new Sport(4, "Curling");
        listAthletes = new ListeAthletes();
        listAthletes.chargerDonnee(pays,sport);
        observer = new ObsPourDetail(tfNo, tfPrenom, tfNom, tfNatio, tfSport);
    }


    @Test
    public void textFields_should_be_empty_if_pos_received_is_negative() {
        action = new Action(Action.SEL, -1);
        observer.update(listAthletes, action);
        assertThat(tfNo.getText()).isEmpty();
        assertThat(tfPrenom.getText()).isEmpty();
        assertThat(tfNom.getText()).isEmpty();
        assertThat(tfNatio.getText()).isEmpty();
        assertThat(tfSport.getText()).isEmpty();
    }

}
