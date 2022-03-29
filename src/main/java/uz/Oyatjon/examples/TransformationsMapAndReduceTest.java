package uz.Oyatjon.examples;

import org.junit.jupiter.api.Test;
import uz.Oyatjon.beans.Car;
import uz.Oyatjon.beans.Person;
import uz.Oyatjon.beans.PersonDto;
import uz.Oyatjon.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TransformationsMapAndReduceTest {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDto> personPersonDTOFunction = person ->
                new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge());

        List<PersonDto> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(PersonDto::map).toList();

        dtos.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(avg);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99};
        int sum = Arrays.stream(integers).reduce(3, Integer::sum);
        System.out.println("dd");
        int sub = Arrays.stream(integers).reduce(3, (a, b) -> {
            System.out.println(a);
            return a - b;
        });
        System.out.println(sum);
        System.out.println(sub);
    }
}

