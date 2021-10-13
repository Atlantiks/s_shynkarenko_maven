package homework13;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInAction {

    public static double getAverageOfCollection(Collection<Integer> collection) {
        return collection
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static Collection<String> getCollectionOfEnglishWordsInUpperCase(Collection<String> collection, String typeOfReturnedCollection) {
        Stream<String> myStream  = collection
                .stream()
                .filter(n -> n.matches("^[AEIOUaeiou]+.*"))
                .map(String::toUpperCase);
        switch(typeOfReturnedCollection) {
            case "List" : return myStream.collect(Collectors.toList());
            case "Set" :  return myStream.collect(Collectors.toSet());
            default : return null;
        }
    }

    public static String filterLowerCaseAndPrint(Collection<String> collection){
        return collection
                .stream()
                .filter(n -> n.matches("[a-zа-я]*"))
                .filter(n -> n.length() == 4)
                .peek(System.out::println)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }
}
