package vue;

import java.util.ArrayList;
import java.awt.List;

import domaine.Pays;
import domaine.Sport;
import metier.Action;
import metier.ListeAthletes;
import metier.ListePays;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ObsPourLstAtheltesTest {

    private ObsPourLstAthletes observer;
    private List list;
    private ListeAthletes listeAthletes;
    private Action action;
    private Pays pays;
    private Sport sport;

    @BeforeTest
    protected void setUp() {
        listeAthletes = new ListeAthletes();
        list = new List();
        pays = new Pays(123);
        sport = new Sport(23);
        observer = new ObsPourLstAthletes(list);
    }

    @Test
    public void shouldListNotEmptyIfActionEqualLoad() {
        listeAthletes.chargerDonnee(pays,sport);
        action = new Action(1);
        observer.update(listeAthletes, action);
        assertThat(list.getItemCount()).isEqualTo(0);
    }

}
