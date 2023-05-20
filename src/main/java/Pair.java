/* Auxiliar class to store two integers in an object. Provides a method to compare two instances. */
public class Pair {

    private Integer firstNumber;
    private Integer secondNumber;

    public Pair(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public boolean compareToPair(Pair other) {
        boolean pairsAreEqual = true;
        if (firstNumber != other.getFirstNumber() || secondNumber != other.getSecondNumber()) {
            pairsAreEqual = false;
        }
        return pairsAreEqual;
    }

    @Override
    public String toString() {
        return String.format("%1$s, %2$s", firstNumber, secondNumber);
    }

}
