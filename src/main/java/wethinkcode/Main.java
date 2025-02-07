package wethinkcode;

import wethinkcode.factory.Animal;
import wethinkcode.factory.AnimalFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> animals = List.of("cat","dog","snake","rabbit");

        try{
            for (String animalName: animals){
                System.out.println("Name: " + animalName);
                Animal animal = new AnimalFactory().getInstanceOf(animalName);
                animal.speak();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}