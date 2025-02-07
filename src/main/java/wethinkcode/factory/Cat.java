package wethinkcode.factory;

class Cat implements Animal {
    private String type = "Mammal";

    @Override
    public void speak() {
        System.out.println("Meow!");
    }

    @Override
    public String getType() {
        return type;
    }

}
