package my.home.comparable_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MyClass {
    public static void main(String[] args) {
        ArrayList<A> arr = new ArrayList<A>();
        arr.add(new A(1, 3));
        arr.add(new A(3, 1));
        arr.add(new A(2, 4));
        System.out.println(arr.toString());

        // Сортировка по х
        arr.sort(null);
        System.out.println(arr.toString());
        // Сортировка по y
        System.out.println("Сортировка по y");
        arr.sort(new Comparator<A>() {
            @Override
            public int compare(A a, A b) {
                if (a.getY() > b.getY()) return 1;
                if (a.getY() < b.getY()) return -1;
                return 0;
            }
        });
        // или
        arr.sort(Comparator.comparingInt(A::getY));
        System.out.println(arr.toString());

        // Сортировка по х по убыванию:
        arr.sort(new ReverseX());
        System.out.println(arr.toString());

        // Сортировка по y по убыванию:
        arr.sort((a, b) -> {
            if (a.getY() > b.getY()) return -1;
            if (a.getY() < b.getY()) return 1;
            return 0;
        });
        System.out.println(arr.toString());
    }
}

class A implements Comparable<A> {
    private int x;
    private int y;

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(A other) {
        if (this.x > other.x) return 1;
        if (this.x < other.x) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "{" + this.x + ";" + this.y + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        A other = (A) obj;
        if (this.x != other.x) return false;
        if (this.y != other.y) return false;
        return true;
    }
}

class ReverseX implements Comparator<A> {
    @Override
    public int compare(A a, A b) {
        return b.compareTo(a);
    }
}
