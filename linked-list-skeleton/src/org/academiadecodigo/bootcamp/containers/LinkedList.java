package org.academiadecodigo.bootcamp.containers;

public class LinkedList <W>{

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(W w) {

        Node node = new Node(w);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        Node iterator = head;
        int calcu = 0;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            if (calcu == index) {
                return iterator.getData();
            }
            calcu++;
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(W w) {

        Node iterator = head;
        int calcu = 0;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            if (iterator.getData() == w) {
                return calcu;
            }
            calcu++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(W w) {


        Node iterator = head;

        while (iterator.getNext() != null) {

            if (iterator.getNext().getData() == w) {

                iterator.setNext(iterator.getNext().getNext());
                length--;

                return true;

            } else {
                iterator = iterator.getNext();
            }

        }
        return false;
    }


    private class Node {

        private W data;
        private Node next;

        public Node(W data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(W data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
