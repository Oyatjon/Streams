package uz.Oyatjon.examples;

import org.junit.jupiter.api.Test;
import uz.Oyatjon.beans.Car;
import uz.Oyatjon.beans.Person;
import uz.Oyatjon.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class SortingTest {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted().toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder()).toList();
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator
                .comparing(Person::getEmail)
                .reversed()
                .thenComparing(Person::getFirstName);

        List<Person> sort = people.stream()
                .sorted(comparing)
                .toList();
        sort.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> topTen = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10).toList();
        topTen.forEach(System.out::println);
    }

}
