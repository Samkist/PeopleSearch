package me.Samkist.Sort;

import me.Samkist.ArrayList.ArrayList;

/**
 * Created by Samkist
 * https://github.com/Samkist
 */
public class BinarySearch<T extends Comparable<T>> {
    private ArrayList<T> list;
    private T item;
    private T result;
    private int checks;

    public BinarySearch(ArrayList<T> list, T item) throws NullPointerException {
        this.list = list;
        this.item = item;
        this.result = search();
    }

    public int getChecks() {
        return checks;
    }

    public T get() {
        return result;
    }

    private T search() throws NullPointerException {
        int first = 0;
        int last = list.size() - 1;
        int middle = (first + last) / 2;

        while(first <= last) {
            if(list.get(middle).compareTo(item) < 0) {
                first = middle + 1;
            } else if(list.get(middle).compareTo(item) == 0) {
                return list.get(middle);
            } else {
                last = middle - 1;
            }
            checks++;
            middle = (first + last) / 2;
        }
            throw new NullPointerException("Item not found");
    }
}
