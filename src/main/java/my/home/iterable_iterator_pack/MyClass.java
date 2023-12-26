package my.home.iterable_iterator_pack;

import java.util.Iterator;

public class MyClass {
    public static void main(String[] args) {

    }
}

class PrintChat implements Iterable<Character>, Iterator<Character> {

    private String str;
    private int index = 0;

    public PrintChat(String str) {
        this.str = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if(this.index < this.str.length()) return true;
        this.index = 0;
        return false;
    }

    @Override
    public Character next() {
        return null;
    }
}
