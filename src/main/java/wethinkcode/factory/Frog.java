package wethinkcode.factory;

class Frog implements Animal {
    private final String type = "Amphibian";

    @Override
    public void speak() {
        System.out.println("Ribbit! Ribbit!");
    }

    @Override
    public String getType() {
        return type;
    }
}
