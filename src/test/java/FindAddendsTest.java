import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


import static org.junit.jupiter.api.Assertions.*;

public class FindAddendsTest {

    /* Create a TreeSet based on a list of integers */
    static void fillSet(TreeSet set, Integer... numbers) {
        for (Integer k: numbers) {
            set.add(k);
        }
    }

    /* Compare two lists of Pairs, by comparing their sizes and elements */
    boolean compareListOfPairs(List<Pair> result, List<Pair> testList) {
        if (result.size() != testList.size()) {
            return false;
        }
        for(int k = 0; k < result.size(); k++) {
            Pair resultPair = result.get(k);
            Pair testPair = testList.get(k);
            if (!resultPair.compareToPair(testPair)) {
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("Even quantity of numbers, and two pairs of integers matching the target sum")
    void findWithAnEvenNumberOfEntries() {
        /* Expected values */
        List<Pair> targetList = new ArrayList<Pair>();
        targetList.add(new Pair(-7, 23));
        targetList.add(new Pair(2, 14));

        /* Obtained values */
        TreeSet<Integer> testNumbers = new TreeSet<Integer>();
        Integer targetSum = 16;
        fillSet(testNumbers, 8, 6, 12, 14, 2, 5, -7, 23, 9, 3);
        List<Pair> testList = FindAddends.findAddendsInOrderedSet(testNumbers, targetSum);

        /* Assertion */
        Assertions.assertTrue(compareListOfPairs(targetList, testList), "Check the lists have the same elements");
    }

    @Test
    @DisplayName("Odd quantity of numbers and only one pair of number matches the desired result")
    void findWithAnOddNumberOfEntries() {
        /* Expected values */
        List<Pair> targetList = new ArrayList<Pair>();
        targetList.add(new Pair(7, 9));

        /* Obtained values */
        TreeSet<Integer> testNumbers = new TreeSet<Integer>();
        Integer targetSum = 16;
        fillSet(testNumbers, 8, -6, 12, 14, -2, 5, 7, 23, 9);
        List<Pair> testList = FindAddends.findAddendsInOrderedSet(testNumbers, targetSum);

        /* Assertion */
        Assertions.assertTrue(compareListOfPairs(targetList, testList), "Check the lists have the same elements");
    }

    @Test
    @DisplayName("Add only odd numbers and try to obtain an even result. No pair of number matches the target.")
    void addOnlyOddNumersAndEvenTarget() {
        /* Expected values (empty) */
        List<Pair> targetList = new ArrayList<Pair>();

        /* Obtained values */
        TreeSet<Integer> testNumbers = new TreeSet<Integer>();
        Integer targetSum = 15;
        fillSet(testNumbers, 8, -6, 12, 14, -2, 4, 8, 22, 10);
        List<Pair> testList = FindAddends.findAddendsInOrderedSet(testNumbers, targetSum);

        /* Assertion */
        Assertions.assertTrue(compareListOfPairs(targetList, testList), "Check the lists have the same elements");
    }
}
