package vue;

import java.awt.List;
import metier.Action;
import metier.ListeAthletes;
import metier.ListePays;
import metier.ListeSports;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ObsPourLstSportsTest {

    private ObsPourLstSports observer;
    private List list;
    private ListeSports listeSports;
    private Action action;

    @BeforeTest
    protected void setUp() {
        listeSports = new ListeSports();
        list = new List();
        observer = new ObsPourLstSports(list);
    }

    @Test
    public void shouldListNotEmptyIfActionEqualLoad() {
        listeSports.chargerDonnee();
        observer.update(listeSports, "LOAD");
        assertThat(list.getItemCount()).isGreaterThan(0);
    }

}
