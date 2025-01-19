package mjic.chp13;

public interface AnotherInterface {
    default String someDefaultMethod() {
        return "Coming from AnotherInterface";
    }
}