import dao.AthleteDao;
import domaine.Athlete;
import domaine.Pays;
import dao.PaysDao;
import metier.ListeAthletes;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class ListAthletesTest {
    private ListeAthletes listeAthletes;
    private AthleteDao dao;

    @BeforeTest
    protected void setUp() {
        /*
        Pour faire ces test, je dois modifier les observer niveau parametres -> donc je dois changer dans le FrmMain, ça fait beaucoup, le temps c'est de l'argent
        *
        listPays = new ListePays();
        dao = mock(PaysDao.class);*/
    }

    /*
    public void shouldNotFillListIfListAthletesEmpty() {

    }*/


    @Test
    public void shouldReturnNullIfPosInvalid() {
        Athlete athlete = listeAthletes.getAthlete(-100);
        assertThat(athlete).isNull();
    }

}
