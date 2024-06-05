package fpij.chp3;

final class Person {

    private final String name;
    private final int age;

    Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    int ageDifference(final Person other) {
        return age - other.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
