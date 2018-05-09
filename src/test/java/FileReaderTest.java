import dao.FileReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FileReaderTest {

    private FileReader reader;

    @BeforeTest
    protected void setUp() {
        reader = new FileReader();
    }

    @Test
    public void shouldReturnNullIfFileIsEmpty() {
        String[] file = reader.readAthletes();
        String[] file2 = reader.readPays();
        String[] file3 = reader.readSports();
        assertThat(file).isNull();
        assertThat(file2).isNull();
        assertThat(file3).isNull();
    }
}
