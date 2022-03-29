package uz.Oyatjon.intStream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class MinTest {

    @Test
    void of() {
        IntStream intStream = IntStream.of(1, 2, 3, 3, 4, 4, 5, 6);
        intStream.forEach(System.out::println);
    }

    @Test
    void range() {
        IntStream.range(0, 10).forEach(System.out::println);
        System.out.println("IntStream.range(0,10).count() = " + IntStream.range(0, 10).count());
        List<Integer> integers = IntStream.range(0, 10)
                .boxed()
                .toList();
        System.out.println("integers = " + integers);
        IntStream.rangeClosed(0, 10).forEach(System.out::print);
        System.out.println();
        OptionalInt minValue = IntStream.of(9, 121, 1, 23, 12, 456, 7, -1).min();
        OptionalInt maxValue = IntStream.of(9, 121, 1, 23, 12, 456, 7, -1).max();
        OptionalDouble average = IntStream.of(9, 121, 1, 23, 12, 456, 7, -1).average();
        System.out.println("maxValue.getAsInt() = " + maxValue.getAsInt());
        System.out.println("average.getAsDouble() = " + average.getAsDouble());

        System.out.println("minValue.orElse(Integer.MIN_VALUE) = " + minValue.orElse(Integer.MIN_VALUE));

    }

    @Test
    void iterate() {
        IntStream
                .iterate(1, var -> var * 3)
                .limit(10)
                .forEach(System.out::println);

    }


    @Test
    void intSupplier() {

        IntStream generate = IntStream.generate(() -> new Random().nextInt(10, 10000)).limit(10);
        generate.forEach(System.out::println);

    }

}
