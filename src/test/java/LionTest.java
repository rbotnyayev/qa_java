import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {
    String sex;
    boolean expectedHasMane;
    Predator predator;

    public LionTest(String sex, boolean expectedHasMane) {
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
        Lion lion = new Lion(sex, predator); //Создал объект оригинального класса Лев с параметром из матрицы Parameterized
        Lion mockedLion = Mockito.mock(Lion.class); //Создал мок класса лев
        if("Самец".equals(sex)) {
            when(mockedLion.doesHaveMane()).thenReturn(true); //Если пол - "Самец" - создаем стаб с значением true
        }else if("Самка".equals(sex)){
            when(mockedLion.doesHaveMane()).thenReturn(false); //Если пол - "Самка" - создаем стаб с значением false
        }
        assertEquals(lion.doesHaveMane(), mockedLion.doesHaveMane()); //вызываю метод doesHaveMane у оригинала и у стаба и сравниваю
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSex() throws Exception {
        new Lion("UnknownSex", predator); //Пытаемся создать объект с непонятным полом
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sex, predator);
        Lion mockedLion = Mockito.mock(Lion.class);
        when(mockedLion.getKittens()).thenReturn(predator.getKittens());
        assertEquals(lion.getKittens(), predator.getKittens());
    }

}
