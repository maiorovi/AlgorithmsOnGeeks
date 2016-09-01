package tasks;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ThirdMaxNumberTest {
    private ThirdMaxNumber thirdMaxNumber;

    @Before
    public void setUp() {
        thirdMaxNumber = new ThirdMaxNumber();
    }

    @Test
    public void thirdMaxNumberSimpleCase() {
        assertThat(thirdMaxNumber.findThirdMaxNumber(new int[]{10, 5, 12, 3,2, -5, 4})).isEqualTo(5);
    }

    @Test
    public void secondTestCaseNothinSpecialHere() {
        assertThat(thirdMaxNumber.findThirdMaxNumber(new int[]{1, 14, 2, 16, 10, 20})).isEqualTo(14);
    }

    @Test
    public void nothinSpecialHereAlso() {
        assertThat(thirdMaxNumber.findThirdMaxNumber(new int[]{19, -10, 20, 14, 2, 16, 10})).isEqualTo(16);
    }
}
