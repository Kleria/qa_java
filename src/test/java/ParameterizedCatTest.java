import com.example.Cat;
import com.example.Feline;
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
public class ParameterizedCatTest {

    private final List<String> expectedFood;

    public ParameterizedCatTest(List<String> expectedFood) {
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {List.of("Животные", "Птицы", "Рыба")},
                {List.of("Сухой корм", "Рыбка Дори", "Пауч")},
                {List.of("Мышки", "Соседский попугай", "Курочка")},
        });
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
    }
}
