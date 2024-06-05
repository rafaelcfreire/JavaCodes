package book.chp3.example6;

public class Person {
    public Person() {
        System.out.printf("Hi, I'm a Person. With a hashcode '%s', I'm unique! %n", super.hashCode());
    }
}