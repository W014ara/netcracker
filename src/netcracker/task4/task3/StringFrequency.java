package netcracker.task4.task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class that implements mechanisms for private analysis of words and symbols
 *
 * @author Bezruk Vladislav
 */
public class StringFrequency {
    //Main fields for processing (first line and second line)
    private final String firstRow;
    private final String secondRow;

    /**
     * Class constructor
     *
     * @param firstRow  - original first line
     * @param secondRow - original second line
     */
    public StringFrequency(String firstRow, String secondRow) {
        this.firstRow = firstRow;
        this.secondRow = secondRow;
    }

    /**
     * A method that returns the frequency statistics of the words in the first line of the created object.
     * At the same time, words in a line are defined through separators ", -;=.:"
     *
     * @return - Returns a hashmap in which the keys are words and the values are the number
     * of words in the string
     */
    public HashMap<String, Integer> wordsFriquencyCount() {
        ArrayList<String> targetStr = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(this.firstRow, ", -;=.:");
        while (st.hasMoreTokens()) {
            targetStr.add(st.nextToken());
        }
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (String word : targetStr) {
            result.merge(word, 1, Integer::sum);
        }
        return result;
    }

    /**
     * A method that creates a set of characters that appear on the first line and the second at the same time
     * (Euler intersection of sets)
     *
     * @return - Returns the set of characters that appear in the first line and the second at the same time
     * (Euler set intersection)
     */
    public HashSet<String> symbolCrossing() {
        HashSet<String> firstSymbolsString = symbolEntry(this.firstRow);
        HashSet<String> secondSymbolsString = symbolEntry(this.secondRow);
        HashSet<String> result = new HashSet<>();
        for (String wordFromStr1 : firstSymbolsString) {
            for (String wordFromStr2 : secondSymbolsString) {
                if (wordFromStr1.equals(wordFromStr2)) {
                    result.add(wordFromStr1);
                }
            }
        }
        return result;
    }

    /**
     * A method that creates a set of characters that are only in the first line and not in the second
     * (exclusive or)
     *
     * @return - returns a hashmap of lines that include characters in the first line and not in the second
     * (exclusive or)
     */
    public HashSet<String> symbolFirstCrossing() {
        HashSet<String> firstSymbolsString = symbolEntry(this.firstRow);
        HashSet<String> secondSymbolsString = symbolEntry(this.secondRow);
        firstSymbolsString.removeAll(secondSymbolsString);
        return firstSymbolsString;
    }

    /**
     * Method implementing symbolic boolean or in two lines
     *
     * @return - returns a hashset of strings that are characters converted from logical OR
     */
    public HashSet<String> symbolAnyCrossing() {
        HashSet<String> firstSymbolsString = symbolEntry(this.firstRow);
        HashSet<String> secondSymbolsString = symbolEntry(this.secondRow);
        return (HashSet<String>) Stream.concat(firstSymbolsString.stream(), secondSymbolsString.stream())
                .collect(Collectors.toSet());
    }

    /**
     * Method to get all characters in a string
     *
     * @param str - original string
     * @return - returns a hashset of characters (string format) that go into the string
     */
    public HashSet<String> symbolEntry(String str) {
        HashSet<String> targetStr = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()) {
            targetStr.add(st.nextToken());
        }
        String[] target = String.join("", targetStr).split("");
        return new HashSet<>(Arrays.asList(target));
    }

    /**
     * @return - Returns a hashmap in which the keys are symbols and the values are the number
     * of symbols in the string
     * @see StringFrequency#wordsFriquencyCount() - analogue of this method, however, instead of words,
     * all characters are counted
     */
    public HashMap<String, Integer> symbolFriquency() {
        ArrayList<String> targetStr = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(this.firstRow, "");
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        while (st.hasMoreTokens()) {
            targetStr.add(st.nextToken());
        }
        String[] target = String.join("", targetStr).split("");
        for (String symbol : target) {
            result.merge(symbol, 1, Integer::sum);
        }
        return result;
    }

    /**
     * Method that implements standard set output
     *
     * @param set - any set
     * @return - returns a list of the elements of a set for later processing or display
     */
    public List<String> printStandard(HashSet<String> set) {
        return new ArrayList<>(set);
    }

    /**
     * @param set - any set
     * @return - returns a reverse list of the elements of a set for later processing or display
     * @see StringFrequency#printStandard(HashSet) - analog that creates a reverse version
     * of the returned list
     */
    public List<String> printReverse(HashSet<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.reverse(list);
        return list;
    }

    /**
     * A method that implements getting a new map symbols. In this case, symbols should be displayed in
     * ascending order of cyclic shift to the left by n bits of the symbol hash function.
     *
     * @param set       - any set
     * @param hashDigit - number of bits for cyclic shift
     * @return - Returns a map, the keys of which are the characters of the set,
     * and the values are the hashcode of these characters, shifted by n digits to the left.
     * In this case, the map is sorted by values.
     */
    public Map<String, Integer> printHash(HashSet<String> set, int hashDigit) {
        ArrayList<Integer> hashcodes = new ArrayList<>();
        HashMap<String, Integer> data = new HashMap<>();
        for (String symbol : set) {
            hashcodes.add(symbol.hashCode());
        }
        for (String elem : set) {
            data.put(elem, 0);
        }
        for (int index = 0; index < hashcodes.size(); ++index) {
            hashcodes.set(index, hashcodes.get(index) << hashDigit);
            data.put((String) data.keySet().toArray()[index], hashcodes.get(index));
        }

        return data.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
    }
}
