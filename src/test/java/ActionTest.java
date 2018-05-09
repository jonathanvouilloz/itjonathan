import metier.Action;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionTest {
    private Action action;
    private static final int LOAD = 1;

    @BeforeTest
    protected void setUp() {
        action = new Action(Action.LOAD);
    }

    @Test
    public void shouldReturnActionIdWhenCallGetAction() {
        int actionId = action.getAction();
        assertThat(actionId).isEqualTo(LOAD);
    }

    @Test
    public void shouldReturnNegativeWhenPosNotSet() {
        int pos = action.getPos();
        assertThat(pos).isNegative();
    }

    @Test
    public void shouldReturnPosWhenPosIsSet() {
        action = new Action(Action.LOAD,2);
        assertThat(action.getPos()).isNotNull();
        assertThat(action.getPos()).isPositive();
        assertThat(action.getPos()).isEqualTo(2);
    }
}
