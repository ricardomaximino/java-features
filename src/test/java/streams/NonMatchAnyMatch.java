package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NonMatchAnyMatch {

    @Test
    public void nonMatch_with_empty_stream(){
        assertTrue(new ArrayList<String>().stream().noneMatch(s -> s.length() == 10));
    }

    @Test
    public void anyMatch_with_empty_stream(){
        assertFalse(new ArrayList<String>().stream().anyMatch(s -> s.length() == 10));
    }
}
