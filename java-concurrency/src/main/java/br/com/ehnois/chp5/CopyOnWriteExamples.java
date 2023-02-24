package br.com.ehnois.chp5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class CopyOnWriteExamples {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> test = new CopyOnWriteArrayList<>(new String[]{"a", "b", "c"});
        Iterator it = test.iterator();
        test.add("d");
        it.forEachRemaining(System.out::println);

        List<String> test2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator it2 = test2.iterator();
        test2.add("d");
        it2.forEachRemaining(System.out::println);
    }
}
