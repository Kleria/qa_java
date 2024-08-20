import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FelineTest {

    @Test
    public void testEatMeatforFelineHasCorrectElements() throws Exception {
        Feline feline = Mockito.spy(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamilyForFelineReturnsCorrectName() throws Exception{
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParametersReturnsExepestedValue() throws Exception{
        Feline feline = new Feline();
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void testGetKittensWithParametersReturnsExepestedValue() throws Exception{
        Feline feline = new Feline();
        assertEquals(2,feline.getKittens(2));
    }

}
