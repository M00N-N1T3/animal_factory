package wethinkcode.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wethinkcode.util.StdoutReader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FrogTest {

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
    public void frogClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Frog> frog = Frog.class;
        assertTrue(animal.isAssignableFrom(frog));
    }

    @Test
    public void frogClassContainsCorrectMethods(){
        Class<Frog> frog = Frog.class;
        List<String> methodsFoundInClass = Arrays.stream(frog.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Frog frog = new Frog();
        stdoutReader.captureOutput();
        frog.speak();
        String expected = "Ribbit! Ribbit!";
        String actual = stdoutReader.getOutputAsText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void correctAnimalClass(){
        Frog frog = new Frog();
        String expected = "Amphibian";
        assertEquals(expected,frog.getType());
    }
}
