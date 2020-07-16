package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ArraysToStream {

    @Test
    public void arraysToStream(){
        int[] intArray = {1,2,3,4,5};
        Map<String,Integer> map = new HashMap<>();

        Arrays.stream(intArray).filter(number -> number%2 == 0).forEach(number -> map.put(String.valueOf(number),number));
        assertEquals(2,map.size());
        assertTrue(map.containsKey("2"));
        assertTrue(map.containsKey("4"));
    }
}
