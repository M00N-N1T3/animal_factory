package wethinkcode.factory;

class Snake implements Animal {
    private final String type = "Reptile";

    @Override
    public void speak() {
        System.out.println("Hisss!");
    }

    @Override
    public String getType() {
        return type;
    }
}
