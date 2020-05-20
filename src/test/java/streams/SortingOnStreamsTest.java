package streams;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortingOnStreamsTest {

    @Test
    public void desc_Sort_By_Date_On_Stream(){
        // given an unsorted list of date
        LocalDate[] dates = {
                LocalDate.of(2020,1,4),
                LocalDate.of(2020,1,2),
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,4)};
        List<String> desiredList = Arrays.asList("2020-01-04","2020-01-04","2020-01-02","2020-01-01");

        // when sorting it d2.compareTo(d1)
        List<String> sortedList = Arrays.stream(dates)
                .sorted((d1,d2) -> d2.compareTo(d1))
                .map(LocalDate::toString)
                .collect(Collectors.toList());

        //then the result is a descending ordered list of date
        Assert.assertEquals(desiredList, sortedList);

    }

    @Test
    public void asc_Sort_By_Date_On_Stream(){
        // given an unsorted list of date
        LocalDate[] dates = {
                LocalDate.of(2020,1,4),
                LocalDate.of(2020,1,2),
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,4)};
        List<String> desiredList = Arrays.asList("2020-01-01","2020-01-02","2020-01-04","2020-01-04");

        // when sorting it d1.compareTo(d2)
        List<String> sortedList = Arrays.stream(dates)
                .sorted((d1,d2) -> d1.compareTo(d2))
                .map(LocalDate::toString)
                .collect(Collectors.toList());

        //then the result is a ascending ordered list of date
        Assert.assertEquals(desiredList, sortedList);

    }

}