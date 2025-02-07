package wethinkcode.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wethinkcode.util.StdoutReader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

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
    public void snakeClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Snake> snake = Snake.class;
        assertTrue(animal.isAssignableFrom(snake));
    }

    @Test
    public void snakeClassContainsCorrectMethods(){
        Class<Snake> snake = Snake.class;
        List<String> methodsFoundInClass = Arrays.stream(snake.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Snake snake = new Snake();
        stdoutReader.captureOutput();
        snake.speak();
        String expected = "Hisss!";
        String actual = stdoutReader.getOutputAsText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void correctAnimalClass(){
        Snake snake = new Snake();
        String expected = "Reptile";
        assertEquals(expected, snake.getType());

    }
}
