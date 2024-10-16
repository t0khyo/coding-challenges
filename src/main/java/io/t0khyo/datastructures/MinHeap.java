package io.t0khyo.datastructures;

import java.util.Arrays;

public class MinHeap {
    private int size = 0;
    private int capacity = 10;
    int[] items = new int[capacity];

    public int peek() {
        if (size == 0) throw new IllegalStateException("The heap is empty.");
        return items[0];
    }

    /*
     * Removes and returns the minimum element from the heap.
     * - The root element (min element) is extracted.
     * - The last element in the heap is moved to the root position.
     * - The size of the heap is reduced.
     * - The heap is restructured to maintain the heap property by "heapifying down."
     */
    public int pull() {
        if (size == 0) throw new IllegalStateException("The heap is empty.");
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    /*
     * Adds a new element to the heap while maintaining the heap property.
     * - Ensures that the heap has enough capacity to hold the new element.
     * - Adds the element at the end of the heap.
     * - Restores the heap property by "heapifying up" the newly added element.
     *
     * @param item The element to be added to the heap.
     * @return The element that was added.
     */
    public int add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
        return item;
    }

    /*
     * Restores the heap property by moving the last element upwards.
     * - The element is compared with its parent, and swapped if the parent is larger.
     * - The process continues until the heap property is restored or the element becomes the root.
     */
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
        }
    }

    /*
     * Restores the heap property by moving the root element downwards.
     * - The root is compared with its children, and swapped with the smaller child if needed.
     * - The process continues until the heap property is restored or the element becomes a leaf.
     */
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }


    // helper method
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

}
