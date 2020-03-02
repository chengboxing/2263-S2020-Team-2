package isu.structures;

/**
 *
 * @author Isaac Griffith
 * @param <E> Element Type
 */
public interface List<E> {

    /**
     * @return first element in the list or null if the list is empty.
     */
    E getFirst();

    /**
     * @return last element in the list or null if the list is empty.
     */
    E getLast();

    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param element Element to be added to the end of the list.
     */
    void addLast(E element);

    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param element Element to be added to the front of the list.
     */
    void addFirst(E element);

    /**
     * Removes the element at the front of the list.
     *
     * @return Element at the front of the list, or null if the list is empty.
     */
    E removeFirst();

    /**
     * Removes the element at the end of the list.
     *
     * @return Element at the end of the list, or null if the list is empty.
     */
    E removeLast();

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param element Element to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    void insert(E element, int index);

    /**
     * Removes the element at the given index and returns the value.
     *
     * @param index Index of the element to remove
     * @return The value of the element at the given index, or null if the index
     * is greater than or equal to the size of the list or less than 0.
     */
    E remove(int index);

    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    E get(int index);

    /**
     * @return The current size of the list. Note that 0 is returned for an
     * empty list.
     */
    int size();

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    boolean isEmpty();

    /**
     * Prints the contents of the list in a single line separating each element
     * by a space to the default System.out
     */
    void printList();
}
