package org.codeforall.ooptimus;

import java.util.Iterator;

public class MyDynamic implements Iterable<Integer> {

    private int position = 0;
    private int min;
    private int max;
    private boolean[] removed;

    public MyDynamic(int min, int max) {
        this.min = min;
        this.max = max;
        removed = new boolean[max - min + 1];
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }


    public class MyIterator implements Iterator<Integer> {
        private int current;

        @Override
        public Integer next() {
            if (position != max) {
                return position++;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if (position < max) {
                return true;
            }
            return false;
        }


    }
}