package mjic.chp13;

public interface SomeInterface {
    String someAbstractMethod();

    default String someDefaultMethod() {
        return "Coming from Some Interface";
    }
}