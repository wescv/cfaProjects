package org.codeforall.ooptimus;


import java.util.PriorityQueue;

public class TodoList {

    PriorityQueue<Item> priorityQueue = new PriorityQueue<>();


    public boolean isEmpty() {

        return priorityQueue.isEmpty();

    }

    public Item remove() {

        return priorityQueue.remove();
    }

    public void add(ImportanceLevel level, int priority, String item) {
        Item item1 = new Item(level, priority, item);
        priorityQueue.add(item1);

    }

    public class Item implements Comparable<Item> {
        private int priority;
        private ImportanceLevel importanceLevel;
        private String item;

        public Item(ImportanceLevel importanceLevel, int priority, String item) {
            this.priority = priority;
            this.importanceLevel = importanceLevel;
            this.item = item;
        }


        @Override
        public int compareTo(Item item) {

            if (importanceLevel.compareTo(item.importanceLevel) == 0) {
                if (priority > item.priority) {
                    return 1;
                }

            } else if (importanceLevel.compareTo(item.importanceLevel) > 0) {

                return 1;

            }
            return -1;

        }


        @Override

        public String toString() {
            System.out.println("--------------------------------------------------------");
            return " Item = " + item +
                    " / Importance level = " + importanceLevel +
                    " / Priority = " + priority + '\'';

        }
    }


    public enum ImportanceLevel {
        HIGH,
        MEDIUM,
        LOW;

    }
}
