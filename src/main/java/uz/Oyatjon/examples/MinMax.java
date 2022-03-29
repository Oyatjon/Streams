package uz.Oyatjon.examples;

import org.junit.jupiter.api.Test;
import uz.Oyatjon.beans.Person;
import uz.Oyatjon.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() throws IOException {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        List<Person> people = MockData.getPeople();
        Person youngest = people.stream()
                .min(Comparator.comparing(Person::getAge))
                .get();
        System.out.println("youngest = " + youngest);
        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
    }
}
