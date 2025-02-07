package wethinkcode.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wethinkcode.util.StdoutReader;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DogTest {

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
    public void dogClassImplementsInterface(){
        Class<Animal> animal = Animal.class;
        Class<Dog> dog = Dog.class;
        assertTrue(animal.isAssignableFrom(dog));
    }

    @Test
    public void dogClassContainsCorrectMethods(){
        Class<Dog> dog = Dog.class;
        List<String> methodsFoundInClass = Arrays.stream(dog.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Dog dog = new Dog();
        stdoutReader.captureOutput();
        dog.speak();
        String actual = stdoutReader.getOutputAsText().trim();
        String expected = "Woof! Woof!";
        assertEquals(expected, actual);
    }

    @Test
    public void correctAnimalClass(){
        Dog dog = new Dog();
        String expected = "Mammal";
        assertEquals(expected, dog.getType());
    }


}
