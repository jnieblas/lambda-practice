import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPractice {
    /** comparator object*/
    Comparator<String> comparatorOld = new Comparator<String>() {

        /**
         * Comparator - compares the length of the first string against the second.
         * @param o1 first string
         * @param o2 second string
         * @return -1 if first is shorter, 1 if greater
         */
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    };

    /** With Lambda */
    Comparator<String> comparatorNew =
            (String s1, String s2) ->
                    Integer.compare(s1.length(), s2.length());

    /** Runnable Interface */
    Runnable r = () -> {
        int i = 0;
        // Short hand for iteration over while loop
        while (i++ < 10)
            System.out.println("it works!");
    };
}

class ComparatorDriver {
    public static void main(String[] args) {
        ComparatorPractice s = new ComparatorPractice();
        // Compare two strings
        System.out.println("Comparison result: " + s.comparatorOld.compare("12345", "1234"));

        // Sort an array of strings using comparator
        String[] arr = new String[]{"123", "4567", "1", "00000", "02"};

        // Pass in comparator, comparator.compare(o1, o2) will be used to organize strings from from least to greatest
        // Sorts the arr, no need to return to another arr
        Arrays.sort(arr, s.comparatorOld);
        System.out.println("Array Sort result (w/o lambda):");

        // Create stream from array, then, for each, print it out on a new line
        Arrays.stream(arr).forEach(System.out::println);

        // With comparator that uses lambda:
        String[] arrTwo = new String[]{"123", "4567", "1", "00000", "02"};
        Arrays.sort(arrTwo, s.comparatorNew);
        System.out.println("\nArray Sort result (w/ lambda):");

        // Create stream from array, then, for each, print it out on a new line
        Arrays.stream(arrTwo).forEach(System.out::println);
    }
}