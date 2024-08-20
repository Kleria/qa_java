import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {
    @Test
    public void testHerbivoreGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = List.of("Трава", "Различные растения");
        assertEquals(food, animal.getFood("Травоядное"));
    }
    @Test
    public void testConfusingAnimalGetFoodHasException() {
        Animal animal = new Animal();
        assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                assertThrows(Exception.class, () -> animal.getFood("Неизвестный вид")).getMessage()
        );
    }
    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedFamily, animal.getFamily());
    }
}
