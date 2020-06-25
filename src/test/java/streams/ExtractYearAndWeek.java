package streams;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class ExtractYearAndWeek {

    @Test
    public void extractYearAndWeekFromALocalDate(){
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int week = date.get(WeekFields.ISO.weekOfWeekBasedYear());

        System.out.println("Year: " + year + " Week: " + week);
    }
}
