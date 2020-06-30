package String;

import org.junit.Test;

public class FormattString {

    @Test
    public void format_string_with_null_argument(){
        Integer number = null;
        System.out.println("The formmated string is: " + String.format("%02d", number));
    }

    @Test
    public void format_string_with_not_null_argument(){
        Integer number = 01000;
        System.out.println("The formmated string is: " + String.format("%02d", number));
    }
}
