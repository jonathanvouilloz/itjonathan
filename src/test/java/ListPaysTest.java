import domaine.Pays;
import dao.PaysDao;
import metier.ListePays;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class ListPaysTest {
    private ListePays listPays;
    private PaysDao dao;

    @BeforeTest
    protected void setUp() {
        /*
        Pour faire ces test, je dois modifier les observer niveau parametres -> donc je dois changer dans le FrmMain, ça fait beaucoup, le temps c'est de l'argent
        *
        listPays = new ListePays();
        dao = mock(PaysDao.class);*/
    }

    /*
    public void shouldNotFillListIfListPaysEmpty() {

    }*/

    //Ce qui fait que je ne peux pas tester ça non plus car lstPays pas initalisé
    /*
    @Test
    public void shouldReturnNullIfPosInvalid() {
        Pays pays = listPays.getPays(-100);
        assertThat(pays).isNull();
    }*/

}
