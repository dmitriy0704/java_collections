package my.home.comparable_comparator;

public class ComparableMain {
    public static void main(String[] args) {
        /*
         * Comparable<T> :
         * int compareTo(T other)
         *
         * Comparator<T>:
         * int compare(T a, T b)
         *
         */

        Integer a = 4;
        Integer b = 3;
        System.out.println(a.compareTo(b));

    }
}
