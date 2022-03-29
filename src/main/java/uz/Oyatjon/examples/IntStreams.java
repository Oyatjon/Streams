package uz.Oyatjon.examples;


import org.junit.jupiter.api.Test;
import uz.Oyatjon.beans.Person;
import uz.Oyatjon.mockdata.MockData;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("with fori");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("with int stream exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .parallel()
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(2, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);
    }
}