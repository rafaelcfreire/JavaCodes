package generics.book.chp2.fruity;

class Fruit implements Comparable<Fruit> {
    private String name;

    public static void main(String[] args) {
        Apple apple = new Apple("Apple");
        Orange orange = new Orange("Orange");

        apple.compareTo(orange);
    }

    @Override
    public int compareTo(final Fruit o) {
        return this.name.compareTo(o.name);
    }
}