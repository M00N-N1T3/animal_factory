package wethinkcode.factory;

import wethinkcode.factory.Cat;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    @Test
    public void catClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Cat> cat = Cat.class;
        assertTrue(animal.isAssignableFrom(cat));
    }

    @Test
    public void catClassContainsCorrectMethods(){
        Class<Cat> cat = Cat.class;
        List<String> methodsFoundInClass = Arrays.stream(cat.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType","equals");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Cat cat = new Cat();
        String expected = "Meow!";
        assertEquals(expected, cat.speak());
    }

    @Test
    public void correctAnimalClass(){
        Cat cat = new Cat();
        String expected = "Mammal";
        assertEquals(expected, cat.getType());
    }
}
