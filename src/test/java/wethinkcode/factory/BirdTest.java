package wethinkcode.factory;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BirdTest {

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
        List<String> expectedMethods = List.of("speak","getType","equals");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Bird bird = new Bird();
        String expected = "Chirp! Chirp!";
        assertEquals(expected, bird.speak());
    }

    @Test
    public void correctAnimalClass(){
        Bird bird = new Bird();
        String expected = "Avian";
        assertEquals(expected, bird.getType());
    }
}
