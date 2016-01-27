package no.sandbox;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class AnagramMapperTest {

    private List<String> testListe = Arrays.asList("niste", "stien", "allfarveien", "konsert", "torsken", "stein");

    @Test
    public void map_anagrams_should_return_map_with_sets() {
        Map<String, Set<String>> result = AnagramMapper.mapAndAnagrams(testListe);
        assertTrue(result.size() > 0);
    }

    @Test
    public void map_anagrams_as_string_should_return_expected_value() {
        String result = AnagramMapper.mapAnagramsAsString(testListe);

        // ikke vedlikeholdbar assert, men for demo purposes...
        assertTrue(result.equals("stein, niste, stien\ntorsken, konsert\nallfarveien"));
    }
}
