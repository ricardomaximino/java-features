import com.brasajava.domain.Email;
import com.brasajava.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaFeatures {
    public static void main(String[] args) {
        // MapToObject
        // range do not include the limit use rangeClosed instead if you need that
        List<Person> people =   IntStream.range(1,20).mapToObj(Person::new).collect(Collectors.toList());

        // Peek - Like a foreach but not final
        Set<String> differentCountries = people.stream()
                .filter(person -> !person.getAddresses().isEmpty())
                .map(person -> person.getAddresses().get(0))
                .map(address -> address.getCountry())
                .peek(System.out::println)
                .collect(Collectors.toSet());

        // FlatMap
        Set<String> differentContact = people.stream()
                .flatMap(person -> Stream.concat(person.getEmails().stream(), person.getTelephones().stream()))
                .map(contact -> contact.getContact())
                .collect(Collectors.toSet());

        // FlatMap
        Long differentContactWithDistinct = people.stream()
                .flatMap(person -> Stream.concat(person.getEmails().stream(), person.getTelephones().stream()))
                .map(contact -> contact.getContact())
                .distinct()
                .count();

        Email email = new Email();
        email.test();
        email.test("One");
        email.test("One","Two","Three");

        // Optional
        Person ricardo = people.stream()
                .filter(person -> person.getName().equals("Ricardo Maximino"))
                .peek(person -> System.out.println(person))
                .filter(person -> person.getLastname().equals("Gonçalves de Moraes"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no Ricardo Maximino Gonçalves de Moraes on this list"));


        System.out.println(people.size());
        System.out.println(differentCountries.size());
        System.out.println("Expected: " + people.size() * 5 + " Actual: " + differentContact.size() + " With distinct: " + differentContactWithDistinct );

    }
}
