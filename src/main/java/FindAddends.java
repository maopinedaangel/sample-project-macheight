import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* This class has the core functionality */
/* A TreeSet is used in order to have the numbers ordered from smallest to largest.
Bubble Sort is avoided and the set is iterated only once */

public class FindAddends {
    private Integer sum;
    private TreeSet<Integer> numbers;
    private File file = null;

    public FindAddends() {
        this.sum = 0;
        this.numbers = new TreeSet<Integer>();
    };

    /* k loops through the set in ascending order; while j does in opposite direction */
    /* The iteration ends when element pointed by j is greater than or equals element pointed by k */
    /* The method return a list of Pair objects */
    public static List<Pair> findAddendsInOrderedSet(TreeSet<Integer> numbers, int target) {
        Iterator k = numbers.iterator();
        Iterator j = numbers.descendingIterator();
        List<Pair> validPairs = new ArrayList<Pair>();
        int first = (int)k.next();
        int second = (int)j.next();
        int sum = first + second;
        while (first < second) {
            if (sum > target) {
                second = (int)j.next();
            } else if (sum == target) {
                validPairs.add(new Pair(first, second));
                first = (int)k.next();
            } else {
                first = (int)k.next();
            }
            sum = first + second;
        }
        return validPairs;
    }
}
