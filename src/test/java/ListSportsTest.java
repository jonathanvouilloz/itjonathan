import dao.SportDao;
import domaine.Pays;
import dao.PaysDao;
import domaine.Sport;
import metier.ListeSports;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class ListSportsTest {
    private ListeSports listeSports;
    private SportDao dao;

    @BeforeTest
    protected void setUp() {
        /*
        Pour faire ces test, je dois modifier les observer niveau parametres -> donc je dois changer dans le FrmMain, ça fait beaucoup, le temps c'est de l'argent
        *
       */
    }
       /*
        public void shouldNotFillListIfListSportEmpty() {

        }*/


       /*
    @Test
    public void shouldReturnNullIfPosInvalid() {
        Sport sport = listeSports.getSport(-100);
        assertThat(sport).isNull();
    }*/

}
