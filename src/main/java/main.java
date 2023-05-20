import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* Main program */
/* Given a list of integers and a target value, find all the pairs of numbers from the list
    whose sum equals the target value */
/* The values are taken from a .txt data file located at src/main/resources */
/* It is assumed that the list doesn't contain any repeated numbers */
/* It is assumed that all values are integer */
/* Some unit tests can be found at src/test/java */

public class main {

    private static TreeSet<Integer> numbers = new TreeSet<Integer>();
    private static Integer sum = 0;

    /* Print the values read from file */
    public static void printNumbers() {
        Iterator k = numbers.iterator();
        System.out.println("Given this list of numbers:");
        while (k.hasNext()) {
            System.out.println(k.next());
        }
        System.out.println("Find all the pairs of numbers whose sum equals " + sum);
    }


    /* Open a .txt file, and read a list of integers and an integer target sum */
    /* The file is expected to have only two lines: the first one with a number of integers, separated by spaces,
        and the second one with only one integer, which is intended to be the target sum */
    /* Call a method name "findAddendsInOrderedSet" from class "FindAddends" to obtain all the valid pairs
        and print the results */
    public static void main(String[] args) {
        String filePath = "src/main/resources/data.txt";
        FileReader fr = new FileReader(filePath);
        numbers = fr.getNumbers();
        sum = fr.getSum();
        printNumbers();
        List<Pair> results = FindAddends.findAddendsInOrderedSet(numbers, sum);
        System.out.println("The following valid pairs were found:");
        for (Pair r: results) {
            System.out.println(r.toString());
        }
    }
}
