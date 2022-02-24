package com.br.ehnois.main;


import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        //filter
        Observable.range(1,100)
                .filter(integer -> integer % 2 == 0).subscribe(integer -> {
            System.out.println("my value is "+integer);
        });
         //map
        Observable.range(1,10)
                .map(integer -> "My Square is "+integer*integer).subscribe(s -> {
            System.out.println(s);
        });
        //reduce
        Observable.range(1,5).reduce(0, (integer, integer2) -> {
            return integer + integer2;
        }).subscribe(s -> {
            System.out.println(s);
        });
        //groupBy and FlatMap
        /*
        Observable.range(1,5)
                .groupBy(integer -> integer % 2 == 0)
                .flatMap()**/
    }
}
