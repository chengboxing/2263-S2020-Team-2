package isu.structures;

/**
 * @author Davis Bolt
 */
public class CircularlyLinkedList<E> implements List<E> {

    /**
     * A class that represents a node in a singly linked list.
     * It holds an element of any type E and the next node in the list.
     */
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> first; //first node in the list
    private Node<E> last; //last node in the list
    private int size = 0; //number of nodes in the list

    /**
     * @return first element in the list or null if the list is empty.
     */
    @Override
    public E getFirst() {
        if (isEmpty()){
            return null;
        }

        return first.getElement();
    }

    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param element Element to be added to the front of the list.
     */
    @Override
    public void addFirst(E element) {
        if (element != null){
            first = new Node<>(element, first);
            if (isEmpty()){
                last = first;
            }

            size++;
        }
    }

    /**
     * Removes the element at the front of the list.
     *
     * @return Element at the front of the list, or null if the list is empty.
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E element = first.getElement();

        first = first.getNext();
        size --;
        if (isEmpty()){
            last = null;
        }

        return element;
    }

    /**
     * @return last element in the list or null if the list is empty.
     */
    @Override
    public E getLast() {
        if (isEmpty()){
            return null;
        }

        return last.getElement();
    }

    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param element Element to be added to the end of the list.
     */
    @Override
    public void addLast(E element) {
        if (element != null){
            Node<E> newTail = new Node<>(element, null);
            if (isEmpty()){
                first = newTail;
            } else {
                last.setNext(newTail);
            }
            last = newTail;

            size++;
        }
    }

    /**
     * Removes the element at the end of the list.
     *
     * @return Element at the end of the list, or null if the list is empty.
     */
    @Override
    public E removeLast() {
        if (isEmpty()){
            return null;
        }

        E element = last.getElement();

        Node curNode = first;
        for (int i = 0; i < size - 1; i++){
            curNode = curNode.getNext();
        }
        last = curNode;
        last.next = null;

        size--;

        return element;
    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param element Element to be added (as long as it is not null).
     * @param index   Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E element, int index) {
        if (element != null && index >= 0){
            if (index >= size){
                addLast(element);
            } else {
                Node<E> curNode = first;
                for (int i = 0; i < index - 1; i++){
                    curNode = curNode.getNext();
                }

                Node<E> newNode = new Node<>(element, curNode.getNext());;
                curNode.setNext(newNode);
                size++;
            }
        }
    }

    /**
     * Removes the element at the given index and returns the value.
     *
     * @param index Index of the element to remove
     * @return The value of the element at the given index, or null if the index
     * is greater than or equal to the size of the list or less than 0.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size){
            return null;
        }

        Node<E> curNode = first;
        for (int i = 0; i < index - 1; i++){
            curNode = curNode.getNext();
        }


        E element = curNode.getNext().getElement();
        curNode.setNext(curNode.getNext().getNext());

        size--;

        return element;
    }

    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size){
            return null;
        }

        Node<E> curNode = first;
        for (int i = 0; i < index; i++){
            curNode = curNode.getNext();
        }

        E element = curNode.getElement();

        return element;
    }

    public E rotate(){
        return first.getNext().getElement();
    }

    /**
     * @return The current size of the list. Note that 0 is returned for an
     * empty list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prints the contents of the list in a single line separating each element
     * by a space to the default System.out
     */
    @Override
    public void printList() {
        Node<E> curNode = first;
        for (int i = 0; i < size; i++){
            System.out.println(curNode.getElement());
            curNode = curNode.getNext();
        }
    }
}
