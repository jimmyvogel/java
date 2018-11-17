package com.jv.optionalNewMethods;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Examples from :
 * http://www.loicmathieu.fr/wordpress/informatique/les-nouveautes-de-java-9-pour-les-developeurs/
 * for the fan of baeldung:
 * http://www.baeldung.com/java-9-optional
 */
public class TestNewMethods {

    public static Optional<String> bigComputation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable("b");
    }

    public static void main(String args[]){
        //Optional.or : a lazy version of orElse
        System.out.println("Optional.or");
        Optional<String> value = Optional.ofNullable("a");
        Supplier<Optional<String>> sup = TestNewMethods::bigComputation;
        System.out.println(value.or(sup));

        //Optional.ifPresent :
        AtomicInteger successCounter = new AtomicInteger(0);
        value.ifPresent(
                v -> successCounter.incrementAndGet());

        //Optional.ifPresentOrElse :
        AtomicInteger successCounter2 = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);
        value.ifPresentOrElse(
                v -> successCounter2.incrementAndGet(),
                onEmptyOptionalCounter::incrementAndGet);

        //Optional.stream : unify the stream and Optional API
        List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList()); //["A"]
    }
}
