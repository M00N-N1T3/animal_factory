package wethinkcode.factory;

import wethinkcode.factory.Dog;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DogTest {

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
        List<String> expectedMethods = List.of("speak","getType","equals");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }

    @Test
    public void correctAnimalSound(){
        Dog dog = new Dog();
        String expected = "Woof! Woof!";
        assertEquals(expected, dog.speak());
    }

    @Test
    public void correctAnimalClass(){
        Dog dog = new Dog();
        String expected = "Mammal";
        assertEquals(expected, dog.getType());
    }


}
