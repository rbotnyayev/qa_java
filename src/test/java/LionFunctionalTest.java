import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionFunctionalTest {
    @Mock
    Predator mockedPredator;

    @Test
    public void getKittens() throws Exception {
        when(mockedPredator.getKittens()).thenReturn(2);
        Lion lion = new Lion(mockedPredator);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        when(mockedPredator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(mockedPredator);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
