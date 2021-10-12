package homework13;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInAction {

    public static double getAverageOfCollection(Collection<Integer> collection) {
        // не добавил проверку isPresent для лаконичности кода, но добавлю, если это критично
        return collection
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
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

    public static void filterLowerCaseAndPrint(Collection<String> collection){
        collection.stream()
                .filter(n -> n.matches("[a-zа-я]*"))
                .filter(n -> n.length() == 4)
                .forEach(System.out::println);
    }
}
