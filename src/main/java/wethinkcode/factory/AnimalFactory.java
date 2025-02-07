package wethinkcode.factory;

public class AnimalFactory {

    public Animal getInstanceOf (String animal) throws AnimalNotFound {
        AnimalType animalType = AnimalType.valueOf(animal.toUpperCase());
        return getInstanceOf(animalType);
    }

    public Animal getInstanceOf(Enum<AnimalType> animalType) throws AnimalNotFound{
        return switch (animalType) {
            case AnimalType.DOG -> new Dog();
            case AnimalType.CAT -> new Cat();
            case AnimalType.SNAKE -> new Snake();
            case AnimalType.FROG -> new Frog();
            case AnimalType.BIRD -> new Bird();
            default -> throw new AnimalNotFound();
        };
    }

}
