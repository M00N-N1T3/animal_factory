package wethinkcode.factory;

class Bird implements Animal {

    private final String type = "Avian";
    @Override
    public void speak(){
        System.out.println("Chirp! Chirp!");
    }

    @Override
    public String getType() {
        return type;
    }

}
