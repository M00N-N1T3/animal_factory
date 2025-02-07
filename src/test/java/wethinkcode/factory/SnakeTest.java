package wethinkcode.factory;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    @Test
    public void snakeClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Snake> snake = Snake.class;
        assertTrue(animal.isAssignableFrom(snake));
    }

    @Test
    public void snakeClassContainsCorrectMethods(){
        Class<Snake> snake = Snake.class;
        List<String> methodsFoundInClass = Arrays.stream(snake.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType","equals");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Snake snake = new Snake();
        String expected = "Woof! Woof!";
        assertEquals(expected, snake.speak());
    }

    @Test
    public void correctAnimalClass(){
        Snake snake = new Snake();
        String expected = "Mammal";
        assertEquals(expected, snake.getType());
    }
}
