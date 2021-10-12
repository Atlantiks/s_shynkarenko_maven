package homework13;

import java.util.Collection;

public class StreamsInAction {

    public static double getAverageOfCollection(Collection<Integer> collection) {
        return collection
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }
}
