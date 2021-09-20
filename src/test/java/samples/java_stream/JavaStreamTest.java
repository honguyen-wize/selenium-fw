package samples.java_stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTest {
    @Test
    public void streamFilterTest(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Donal");
        names.add("Alex");
        names.add("Adam");
        names.add("Ram");
        names.add("Mr Bean");

        // print the count of the items starting with "A"
        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        // print all names starting with "A"
        names.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println("Starting with A: " + s));

        // print all names with the length > 4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println("Length > 4: " + s));

        // do multiple commands
        names.stream().filter(s -> s.length() > 4).forEach(s -> {
            System.out.print("Here is the name with length > 4: ");
            System.out.println(s);
        });
    }

    @Test
    public void streamMap(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Donal");
        names.add("Alex");
        names.add("Ram");
        names.add("Adam");
        names.add("Mr Bean");

        // print the names ending with "m", and convert the result to UPPERCASE
        names.stream().filter(s -> s.endsWith("m")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println("Mapped: " + s));

        // Mapped and Sorted
        names.stream().filter(s -> s.endsWith("m")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println("Mapped & Sorted: " + s));

        // Combine 2 streams with concat
        List<String> namesList2 = Arrays.asList("Honey", "Min");
        Stream<String> combinedStream = Stream.concat(names.stream(), namesList2.stream());
//        combinedStream.sorted().forEach(s -> System.out.println("Combined list name: " + s));

        // check if the combinedStream contains "Adam"
        boolean hasAdamInStream = names.stream().anyMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(hasAdamInStream);
    }

    @Test
    public void streamCollect(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Donal");
        names.add("Alex");
        names.add("Ram");
        names.add("Adam");
        names.add("Mr Bean");
        names.add("Alex");

        // convert stream into collection such as List (could be Map)
        List<String> listNames = names.stream().filter(s -> s.endsWith("m")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("The first item in the list ending with 'm': " + listNames.get(0));

        // get distinct names only
        names.stream().distinct().forEach(s -> System.out.println("Distinct name: " + s));
    }
}
