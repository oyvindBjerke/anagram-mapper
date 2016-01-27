package no.sandbox;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramMapper {

    public static Map<String, Set<String>> mapAndAnagrams(List<String> stringList) {

        // opprett map med String som nøkkel og Set med String som verdier
        Map<String, Set<String>> result = new HashMap<>();

        // populer map med verdier
        stringList.stream().forEach(entry -> {
            String key = extractKey(entry);
            if(result.containsKey(key)) {
                result.get(key).add(entry);
            }
            else {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(entry);
                result.put(key, newSet);
            }
        });
        return result;
    }

    private static String extractKey(String entry) {
        char[] chars = entry.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    public static String mapAnagramsAsString(List<String> stringList) {
        Map<String, Set<String>> result = mapAndAnagrams(stringList);
        return result.values().stream().map(set -> set.stream().collect(Collectors.joining(", "))).collect(Collectors.joining("\n"));
    }

}
