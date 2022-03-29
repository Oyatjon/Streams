package uz.Oyatjon.examples;


//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import uz.Oyatjon.beans.Car;
import uz.Oyatjon.mockdata.MockData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DistinctAndSets {

    @Test
    public void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinct = numbers.stream().distinct().toList();
//        Assertions.assertEquals(6, distinct.size(), "Length of distinct collection does not match");
        Assertions.assertThat(distinct).hasSize(2);
        System.out.println(distinct);
    }


    @Test
    public void distinctCars() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> distinct = cars.stream().distinct().toList();
//        Assertions.assertEquals(6, distinct.size(), "Length of distinct collection does not match");
        System.out.println("cars.size() = " + cars.size());
        System.out.println("distinct.size() = " + distinct.size());

    }


    @Test
    public void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinct = new HashSet<>(numbers);
        Assertions.assertThat(distinct).hasSize(9);
        System.out.println(distinct);
    }
}
