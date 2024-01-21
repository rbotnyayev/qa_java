import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//Тест данного класса был создан вне условий задания, по моей инициативе, для получения доп практики.
@RunWith(Parameterized.class)
public class AnimalTest {

    public String animalKind;
    public List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood){
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters //Параметризовал значения типа животного и ожидаемого списка пищи для конкретного типа
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

    @Test(expected = Exception.class) //Проверка выброса исключения
    public void testAnimalWithInvalidType() throws Exception {
        Animal animal = new Animal(); //Создаю объект класса Животное
        animal.getFood("Непонятный тип"); //Вызываю метод с непонятным типом, для проверки на выброс исключения
    }

    @Test
    public void getFamilyTest(){
        Animal mockedAnimal = Mockito.mock(Animal.class); //Создаю мок класса Животное
        Animal animal = new Animal(); //Создаю объект класса Животное
        when(mockedAnimal.getFamily()).thenReturn("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        assertEquals(animal.getFamily(), mockedAnimal.getFamily()); //Сравниваю значения оригинального объекта Животное и стаба
    }
}
