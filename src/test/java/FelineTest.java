import com.example.Feline;
import org.junit.Test;



import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest(){
        assertEquals(1, feline.getKittens());
    }
}
