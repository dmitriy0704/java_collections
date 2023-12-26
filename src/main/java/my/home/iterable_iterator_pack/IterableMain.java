package my.home.iterable_iterator_pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class IterableMain {
    public static void main(String[] args) {
        /*
         * Методы Iterator:
         * - hasNext()
         * - next()
         * - remove()
         * */

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4);
        System.out.println(list.toString());

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator.remove();
        System.out.println(list.toString());

        for (Integer i : list){
            System.out.print(i);
        }
    }
}
