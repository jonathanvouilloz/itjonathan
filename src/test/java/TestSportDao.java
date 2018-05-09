import dao.FileReader;
import java.util.List;
import static org.mockito.Mockito.*;
import dao.SportDao;
import domaine.Pays;
import domaine.Sport;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;



public class TestSportDao {
    private SportDao dao;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
        dao = new SportDao(reader);
    }


    @Test
    public void shouldReturnEmptyListIfArrayIsEmpty() {
        when(reader.readSports()).thenReturn(new String[] {});
        List sportL = dao.getListeSports();
        assertThat(sportL).isEmpty();
    }

    @Test
    public void shouldReturnSingleItemIfArrayGotOneItem()
    {
        when(reader.readSports()).thenReturn(new String[] {"15;Snowboard"});
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(1);
        assertThat(sports).contains(new Sport(15, "Snowboard"));
    }


    @Test
    public void shouldReturnMultipleIfArrayGotMoreThanOneItems()
    {
        when(reader.readSports()).thenReturn(new String[] {
                "12;Ski",
                "14;Snowboard",
                "16;Marche",
                "11;Velo"
        });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).hasSize(4);
    }


    @Test
    public void souldReturnDuplicateIfArrayGotDuplicate()
    {
        when(reader.readSports()).thenReturn(new String[] {
                "12;Ski",
                "16;Marche",
                "16;Marche"
        });
        List sports = dao.getListeSports();
        assertThat(sports).isNotEmpty();
        assertThat(sports).contains(
                new Sport(12,"Ski"),
                new Sport(16, "Marche"),
                new Sport(16, "Marche")
        );
    }

}
