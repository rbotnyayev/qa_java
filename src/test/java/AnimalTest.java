import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class AnimalTest {

    public String animalKind;
    public List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void getFoodTest() throws Exception{
        Animal animal = new Animal();
        Animal mockedAnimal = Mockito.mock(Animal.class);
        when(mockedAnimal.getFood(animalKind)).thenReturn(expectedFood);
        List<String> actual = animal.getFood(animalKind);
        assertEquals(expectedFood, actual);
    }
}
