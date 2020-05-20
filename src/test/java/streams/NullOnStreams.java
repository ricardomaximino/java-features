package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NullOnStreams {

    @Test
    public void null_On_Streams(){
        Integer[] numbers = {1,2,3,null,5};

        List<Integer> numberList = Arrays.stream(numbers)
                .filter(Objects::nonNull)
                .map(num -> num + 1)
                .collect(Collectors.toList());
        Assert.assertEquals(4,numberList.size());
    }
}
