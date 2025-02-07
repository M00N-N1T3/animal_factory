package wethinkcode.factory;

class Dog implements Animal {
    private final String type = "Mammal";

    @Override
    public void speak() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public String getType() {
        return type;
    }
}
