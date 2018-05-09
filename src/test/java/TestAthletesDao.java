import dao.FileReader;
import dao.*;
import domaine.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestAthletesDao {
    private AthleteDao dao;
    private FileReader reader;
    protected Pays paysD;
    private Sport sport;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
        dao = new AthleteDao(reader);
        sport = new Sport(3);
        paysD = new Pays(30);
    }

    @Test
    public void shouldReturnEmptyListIfArrayIsEmpty() {
        when(reader.readAthletes()).thenReturn(new String[] {});
        List Atl = dao.getListeAthletes(paysD,sport);
        assertThat(Atl).isEmpty();
    }

    @Test
    public void shouldReturnSingleItemIfArrayGotOneItem()
    {

        when(reader.readAthletes()).thenReturn(new String[] {"30;3;13;Abby;RINGQUIST"});
        List athletesL = dao.getListeAthletes(paysD,sport);
        assertThat(athletesL).isNotEmpty();
        assertThat(athletesL).hasSize(1);
        assertThat(athletesL).contains(new Athlete(13, "Abby", "RINGQUIST",paysD,sport));
    }


    @Test
    public void shouldReturnMultipleIfArrayGotMoreThanOneItems()
    {
        when(reader.readAthletes()).thenReturn(new String[] {
                "30;3;154;Jean;MOUOU",
                "30;3;12;Albert;MIMI"
        });
        List athletesL = dao.getListeAthletes(paysD,sport);
        assertThat(athletesL).isNotEmpty();
        assertThat(athletesL).hasSize(2);
    }


    @Test
    public void souldReturnDuplicateIfArrayGotDuplicate()
    {
        when(reader.readAthletes()).thenReturn(new String[] {
                "30;3;154;Jean;MOUOU",
                "30;3;14;Albert;MIMI",
                "30;3;14;Albert;MIMI"
        });
        List athletesL = dao.getListeAthletes(paysD,sport);
        assertThat(athletesL).isNotEmpty();
        assertThat(athletesL).contains(
                new Athlete(154, "Jean", "MOUOU",paysD,sport),
                new Athlete(14, "Albert", "MIMI",paysD,sport),
                new Athlete(14, "Albert", "MIMI",paysD,sport)
        );
    }

}
