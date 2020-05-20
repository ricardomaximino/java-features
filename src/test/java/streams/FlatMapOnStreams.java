package streams;

import com.brasajava.domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapOnStreams {

    @Test
    public void flat_From_One_Object_Two_Different_Field_Of_The_Same_Type(){
        //given a list of person, each person has 2 e-mails(Home,Work) and 3 telephone(Home,Work,Mobile)
        // the class e-mail and telephone implements Contact
        //range do not include the limit use rangeClosed instead if you need that
        List<Person> people =   IntStream.range(1,21).mapToObj(Person::new).collect(Collectors.toList());

        //when
        List<String> contactNameList = people.stream()
                .flatMap(person -> Stream.concat(person.getEmails().stream(), person.getTelephones().stream()))
                .map(contact -> contact.getName())
                .collect(Collectors.toList());

        //them
        Assert.assertEquals(100, contactNameList.size());

    }

    @Test
    public void flat_From_One_Object_Two_Different_Field_Of_The_Same_Type_With_Distinct(){
        //given a list of person, each person has 2 e-mails(Home,Work) and 3 telephone(Home,Work,Mobile)
        // the class e-mail and telephone implements Contact
        //range do not include the limit use rangeClosed instead if you need that
        List<Person> people =   IntStream.range(1,21).mapToObj(Person::new).collect(Collectors.toList());

        //when
        List<String> contactNameList = people.stream()
                .flatMap(person -> Stream.concat(person.getEmails().stream(), person.getTelephones().stream()))
                .map(contact -> contact.getName())
                .distinct()
                .collect(Collectors.toList());

        //them
        Assert.assertEquals(3, contactNameList.size());

    }

    @Test
    public void flat_From_One_Object_Two_Different_Field_Of_The_Same_Type_With_Collect_To_Set(){
        //given a list of person, each person has 2 e-mails(Home,Work) and 3 telephone(Home,Work,Mobile)
        // the class e-mail and telephone implements Contact
        //range do not include the limit use rangeClosed instead if you need that
        List<Person> people =   IntStream.range(1,21).mapToObj(Person::new).collect(Collectors.toList());

        //when
        Set<String> contactNameList = people.stream()
                .flatMap(person -> Stream.concat(person.getEmails().stream(), person.getTelephones().stream()))
                .map(contact -> contact.getName())
                .collect(Collectors.toSet());

        //them
        Assert.assertEquals(3, contactNameList.size());

    }
}
