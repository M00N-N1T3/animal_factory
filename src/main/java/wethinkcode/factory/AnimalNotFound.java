package wethinkcode.factory;

public class AnimalNotFound extends Exception {
    public AnimalNotFound(String errorMessage) {
        super(errorMessage);
    }
    public AnimalNotFound(){
      super("Animal does not exist yet");
    }
}
