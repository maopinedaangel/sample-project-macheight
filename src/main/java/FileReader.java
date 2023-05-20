import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/* This class uses a Scanner object to read a file, get a number of integers and put them in a TreeSet */
/* Also reads the target sum and makes all the values available through public getters */
public class FileReader {

    private Integer sum;
    private TreeSet<Integer> numbers;
    private String file;

    public FileReader(String file) {
        this.file = file;
        this.sum = 0;
        this.numbers = new TreeSet<Integer>();
        this.readFileWithScanner();
    }

    public Integer getSum() {
        return sum;
    }

    public TreeSet<Integer> getNumbers() {
        return numbers;
    }


    public void readFileWithScanner() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(this.file));
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            int number = Integer.parseInt(scanner.next());
            if (scanner.hasNext()) {
                numbers.add(number);
            } else {
                sum = number;
            }
        }
    }
}
