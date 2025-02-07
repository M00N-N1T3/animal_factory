package wethinkcode.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wethinkcode.util.StdoutReader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {
    private StdoutReader stdoutReader;

    @BeforeEach
    void SetUp(){
        this.stdoutReader = new StdoutReader();
    }

    @AfterEach
    public void TearDown(){
        stdoutReader.closeOutputStream();
    }

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
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Cat cat = new Cat();
        stdoutReader.captureOutput();
        cat.speak();
        String expected = "Meow!";
        String actual = stdoutReader.getOutputAsText().trim();
        assertEquals(expected,actual);
    }

    @Test
    public void correctAnimalClass(){
        Cat cat = new Cat();
        String expected = "Mammal";
        assertEquals(expected, cat.getType());
    }
}
