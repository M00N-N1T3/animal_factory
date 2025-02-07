package wethinkcode.factory;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FrogTest {

    @Test
    public void frogClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Frog> frog = Frog.class;
        assertTrue(animal.isAssignableFrom(frog));
    }

    @Test
    public void frogClassContainsCorrectMethods(){
        Class<Frog> frog = Frog.class;
        List<String> methodsFoundInClass = Arrays.stream(frog.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType","equals");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Frog frog = new Frog();
        String expected = "Woof! Woof!";
        assertEquals(expected, frog.speak());
    }

    @Test
    public void correctAnimalClass(){
        Frog frog = new Frog();
        String expected = "Mammal";
        assertEquals(expected, frog.getType());
    }
}
