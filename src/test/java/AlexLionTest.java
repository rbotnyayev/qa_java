import com.example.AlexLion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexLionTest {
    AlexLion alex = new AlexLion();

    public AlexLionTest() throws Exception {
    }

    @Test
    public void testPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetFriends() {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void testGetKittens() {
        assertEquals(0, alex.getKittens());
    }

}
