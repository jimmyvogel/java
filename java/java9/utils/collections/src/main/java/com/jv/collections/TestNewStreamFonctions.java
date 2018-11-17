package com.jv.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Some example are from :
 * http://www.loicmathieu.fr/wordpress/informatique/les-nouveautes-de-java-9-pour-les-developeurs/
 * Other link for fan of Baeldung:
 * http://www.baeldung.com/java-9-stream-api
 */
public class TestNewStreamFonctions {

    public static void main(String args[]){

        System.out.println("TakeWhile");
        List<Integer> l = List.of(1,2,3,2,2,6);
        l.forEach(System.out::print);
        System.out.println("");
        List<Integer> o = l.stream().takeWhile(x -> x < 3).collect(Collectors.toList());
        o.forEach(System.out::print);
        System.out.println("");

        System.out.println("DropWhile");
        List<Integer> l2 = List.of(1,2,3,2,2,6);
        l2.forEach(System.out::print);
        System.out.println("");
        List<Integer> o2 = l.stream().dropWhile(x -> x < 3).collect(Collectors.toList());
        o2.forEach(System.out::print);
        System.out.println("");

        System.out.println("Stream.iterate");
        Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(System.out::print);
        System.out.println("");

        System.out.println("OfNullable in stream");//ofNullable : returning Stream.empty() for null element
        List<String> collection = List.of("a", "b", "c");
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);
        //java 8 style : we need to make a check to know if it's null or not
        collection.stream()
                .flatMap(s -> {
                    Integer temp = map.get(s);
                    return temp != null ? Stream.of(temp) : Stream.empty();
                })
                .collect(Collectors.toList());
        //java 9 style
        collection.stream().flatMap(s -> Stream.ofNullable(map.get(s))).collect(Collectors.toList());

        System.out.println("FlatMapping and filtering disponible via Collectors");
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);
        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())
                ));
    }
}
