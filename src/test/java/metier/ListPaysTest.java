package metier;

import domaine.Pays;
import dao.PaysDao;
import metier.ListePays;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListPaysTest {
    private ListePays listPays;
    private PaysDao dao;

    @BeforeTest
    protected void setUp() {

        listPays = new ListePays();
        dao = mock(PaysDao.class);
    }

    @Test
    public void shouldNotFillListIfListPaysEmpty() {
        when(dao.getListePays()).thenReturn(new ArrayList());
        listPays.chargerDonnee();
        List paysList = listPays.getList();
        assertThat(paysList).isNotEmpty();
    }

    //Ce qui fait que je ne peux pas tester ça non plus car lstPays pas initalisé

    @Test
    public void shouldReturnNullIfPosInvalid() {
        Pays pays = listPays.getPays(-100);
        assertThat(pays).isNull();
    }



}
