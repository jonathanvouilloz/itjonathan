package vue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrmMainTest {
    private FrmMain frmMain;

    @BeforeTest
    protected void setUp(){
        frmMain = new FrmMain();
    }

    @Test
    public void frmMainNotNull(){
        assertThat(frmMain).isNotNull();
    }
}
