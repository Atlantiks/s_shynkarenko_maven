package homework13;

import java.util.*;

public class StreamsInAction {
    static List<Integer> myIntegers= new ArrayList<>();
    static List<String> myStrings = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 25; i++) {
            myIntegers.add((int)(1 + Math.random() * 100));
        }
        System.out.println("Список целочесленных значений: ");
        myIntegers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(myIntegers.stream().reduce(Integer::sum).get() / (double) myIntegers.size());
        System.out.println(getAverageOfCollection(myIntegers));
    }

    public static double getAverageOfCollection(Collection<Integer> collection) {
        return Arrays.stream(collection.toArray(new Integer[0]))
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }
}
