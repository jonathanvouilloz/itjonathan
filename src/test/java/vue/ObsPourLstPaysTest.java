package vue;

import java.util.ArrayList;
import java.awt.List;

import domaine.Pays;
import metier.Action;
import metier.ListeAthletes;
import metier.ListePays;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ObsPourLstPaysTest {

    private ObsPourLstPays observer;
    private List list;
    private ListePays listPays;
    private Action action;

    @BeforeTest
    protected void setUp() {
        listPays = new ListePays();
        list = new List();
        observer = new ObsPourLstPays(list);
    }

    @Test
    public void shouldListNotEmptyIfActionEqualLoad() {
        listPays.chargerDonnee();
        observer.update(listPays, "LOAD");
        assertThat(list.getItemCount()).isGreaterThan(0);
    }

}
