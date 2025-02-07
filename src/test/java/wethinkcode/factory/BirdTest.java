package wethinkcode.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wethinkcode.util.StdoutReader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BirdTest {
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
    public void birdClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Bird> bird = Bird.class;
        assertTrue(animal.isAssignableFrom(bird));
    }

    @Test
    public void birdClassContainsCorrectMethods(){
        Class<Bird> bird = Bird.class;
        List<String> methodsFoundInClass = Arrays.stream(bird.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Bird bird = new Bird();
        stdoutReader.captureOutput();
        bird.speak();
        String actual = stdoutReader.getOutputAsText().trim();
        String expected = "Chirp! Chirp!";
        assertEquals(expected, actual);
    }

    @Test
    public void correctAnimalClass(){
        Bird bird = new Bird();
        String expected = "Avian";
        assertEquals(expected, bird.getType());
    }
}
