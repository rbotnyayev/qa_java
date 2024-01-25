import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionConstructorTest {
    String sex;
    boolean expectedHasMane;

    public LionConstructorTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
    });
}
    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSex() throws Exception {
        new Lion("UnknownSex");
    }

}
