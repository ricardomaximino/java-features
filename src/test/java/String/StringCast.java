package String;

import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StringCast {

    @Test
    public void convert_string_to_integer(){
        String strDate = "01/05/2020";
        String[] strArray = strDate.split("/");
        System.out.println(strArray[0] + " - " + strArray[1] + " - " + strArray[2]);

        int day = Integer.parseInt(strArray[0]);
        int month = Integer.parseInt(strArray[1]);
        int year = Integer.parseInt(strArray[2]);
        System.out.println("day:" + day + " month: " + month + " year: " + year);

        LocalDate date = LocalDate.of(year,month,day);
        System.out.println(date);

        Date oldDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(oldDate);

    }
}
