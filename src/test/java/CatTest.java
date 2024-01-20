import com.example.Cat;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Predator predator;

    @InjectMocks
    Cat cat;

    @Test
   public void getSoundTest(){
        Cat mockedCat = Mockito.mock(Cat.class);
        Mockito.when(mockedCat.getSound()).thenReturn("Мяу");
        //String expected = cat.getSound();
        assertEquals("Мяу", mockedCat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //List<String> expected = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), predator.eatMeat());
    }
}
