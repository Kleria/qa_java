import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testLionHasMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionessleDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionOfUnknownlidSexHasException() throws Exception {
        new Lion("Некорректный пол", feline);
    }

    @Test
    public void testGetKittens() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }


    @Test
    public void testGetFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, lion.getFood());
    }
}