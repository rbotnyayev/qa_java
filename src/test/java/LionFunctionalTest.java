import com.example.Feline;
import com.example.Lion;
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
    Feline mockedFeline;

    @Test
    public void getKittens() throws Exception {
        when(mockedFeline.getKittens()).thenReturn(2);
        Lion lion = new Lion(mockedFeline);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        when(mockedFeline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(mockedFeline);
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
