package metier;

import dao.SportDao;
import domaine.Pays;
import dao.PaysDao;
import domaine.Sport;
import metier.ListeSports;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListSportsTest {
    private ListeSports listeSports;
    private SportDao dao;

    @BeforeTest
    protected void setUp() {
        listeSports = new ListeSports();
        dao = mock(SportDao.class);
    }

        public void shouldNotFillListIfListSportEmpty() {
            when(dao.getListeSports()).thenReturn(new ArrayList());
            listeSports.chargerDonnee();
            List sports = listeSports.getList();
            assertThat(sports).isNotEmpty();
        }



    @Test
    public void shouldReturnNullIfPosInvalid() {
        Sport sport = listeSports.getSport(-100);
        assertThat(sport).isNull();
    }

}
