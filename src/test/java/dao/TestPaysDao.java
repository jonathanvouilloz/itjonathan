package dao;

import dao.FileReader;
import java.util.List;
import dao.PaysDao;
import static org.mockito.Mockito.*;

import domaine.Pays;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;



public class TestPaysDao {
    private PaysDao dao;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
        dao = new PaysDao(reader);
    }

    @Test
    public void shouldReturnEmptyListIfArrayIsEmpty() {
        when(reader.readPays()).thenReturn(new String[] {});
        List paysL = dao.getListePays();
        assertThat(paysL).isEmpty();
    }

    @Test
    public void shouldReturnSingleItemIfArrayGotOneItem()
    {
        when(reader.readPays()).thenReturn(new String[] {"53;DEN;Danemark"});
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(1);
        assertThat(pays).contains(new Pays(53, "DEN", "Danemark"));
    }


    @Test
    public void shouldReturnMultipleIfArrayGotMoreThanOneItems()
    {
        when(reader.readPays()).thenReturn(new String[] {
                "12;AUT;Autriche",
                "34;CAN;Canada",
                "53;DEN;Danemark",
                "66;FRA;France"
        });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).hasSize(4);
    }


    @Test
    public void souldReturnDuplicateIfArrayGotDuplicate()
    {
        when(reader.readPays()).thenReturn(new String[] {
                "12;AUT;Autriche",
                "12;AUT;Autriche",
                "53;DEN;Danemark"
        });
        List pays = dao.getListePays();
        assertThat(pays).isNotEmpty();
        assertThat(pays).contains(
                new Pays(12, "AUT", "Autriche"),
                new Pays(12, "AUT", "Autriche"),
                new Pays(53, "DEN", "Danemark")
        );
    }

}
