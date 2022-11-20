package generics.upperbound;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    void doSomething() {
        System.out.println("Do Something");
    }

    public static void main(String[] args) {
        List<? extends Foo> list = new ArrayList<>();
//      WON'T WORK DUE TO PECS
//      list.add(new Bar());
    }


}

class Bar extends Foo {
    void doSomethingElse() {
        System.out.println("Do Something else");
    }
}
