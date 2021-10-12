package homework13;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testGetCollectionOfEnglishWordsInUpperCase() {
        myStrings.add("Apple");
        myStrings.add("Apple");
        myStrings.add("Яблоко");
        myStrings.add("Банан");
        myStrings.add("Oreo");
        myStrings.add("Груша");
        myStrings.add("Pineapple");
        myStrings.add("Coconut");
        myStrings.add("Киви");
        myStrings.add("U");
        myStrings.add("Арбуз");
        // добавляем слово, начинающееся латинской буквой и содержащее далее кириллицу
        // для проверки правильности подобранного регулярного выражения
        myStrings.add("Aрбуз");


        List<String> myList = (List<String>) StreamsInAction.getCollectionOfEnglishWordsInUpperCase(myStrings,"List");
        Set<String> mySet = (Set<String>) StreamsInAction.getCollectionOfEnglishWordsInUpperCase(myStrings,"Set");
        System.out.println(myList);
        System.out.println(mySet);
        Assert.assertEquals(7, myList.size());
        Assert.assertEquals(6, mySet.size());
    }

    @Test
    public void testFilterLowerCaseAndPrint() {
        myStrings.add("яблоко");
        myStrings.add("мама");
        myStrings.add("iPhone");
        myStrings.add("Mitsubishi");
        myStrings.add("daddy");
        myStrings.add("aunt");

        StreamsInAction.filterLowerCaseAndPrint(myStrings);
    }
}
