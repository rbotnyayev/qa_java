import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline feline = new Feline();
    @Mock
    Feline mockedFeline;

    @Test
    public void testEatMeat() throws Exception {
        when(mockedFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(feline.eatMeat(), mockedFeline.eatMeat());
    }

    @Test
    public void getFamilyTest(){
        when(mockedFeline.getFamily()).thenReturn("Кошачьи");
        assertEquals(feline.getFamily(), mockedFeline.getFamily());
    }

    @Test
    public void getKittensTest(){
        when(mockedFeline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), mockedFeline.getKittens());
    }
}
