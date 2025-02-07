package wethinkcode.factory;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import  static  org.junit.jupiter.api.Assertions.*;

public class AnimalFactoryInterfaceTest {

    @Test
    public void classIsAnInterface(){
        Class<Animal> animal = Animal.class;
        assertTrue(animal.isInterface());
    }

    @Test
    public void classHasCorrectMethods(){
        Class<Animal> animal = Animal.class;
        List<String> methodsFoundInClass = Arrays.stream(animal.getDeclaredMethods()).map(Method::getName).toList();
        List<String> expectedMethods = List.of("speak","getType");
        assertTrue(methodsFoundInClass.containsAll(expectedMethods));
    }
}
