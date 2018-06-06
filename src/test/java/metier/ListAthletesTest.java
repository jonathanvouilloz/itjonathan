package metier;

import dao.AthleteDao;
import domaine.Athlete;
import domaine.Pays;
import dao.PaysDao;
import domaine.Sport;
import metier.ListeAthletes;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListAthletesTest {
    private ListeAthletes listeAthletes;
    private AthleteDao dao;
    private Pays pays;
    private Sport sport;

    @BeforeTest
    protected void setUp() {

        listeAthletes = new ListeAthletes();
        dao = mock(AthleteDao.class);
        pays = new Pays(123);
        sport = new Sport(23);
    }

    @Test
    public void shouldNotFillListIfListAthletesEmpty() {
        when(dao.getListeAthletes(pays,sport)).thenReturn(new ArrayList());
        listeAthletes.chargerDonnee(pays,sport);
        List athletesList = listeAthletes.getList();
        assertThat(athletesList).isEmpty();
    }


    @Test
    public void shouldReturnNullIfPosInvalid() {
        Athlete athlete = listeAthletes.getAthlete(-100);
        assertThat(athlete).isNull();
    }

    @Test
    public void shouldReturnNullIfPosToHigh() {
        Athlete athlete = listeAthletes.getAthlete(Integer.MAX_VALUE);
        assertThat(athlete).isNull();
    }


}
