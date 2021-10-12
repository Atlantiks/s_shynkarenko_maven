package homework13;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamsInActionTest {
    static List<Integer> myIntegers= new ArrayList<>();
    static List<String> myStrings = new ArrayList<>();

    @Test
    public void testGetAverageOfCollection() {
        for (int i = 0; i < 25; i++) {
            myIntegers.add((int)(1 + Math.random() * 100));
        }
        Assert.assertEquals(
                myIntegers.stream().reduce(Integer::sum).get() / (double) myIntegers.size(),
                        StreamsInAction.getAverageOfCollection(myIntegers),
                   0.01);
    }
}
