package tasks;

import tasks.exceptions.EmptyQueueException;

public class Queue<T extends Comparable<T>> {
    private T[] container;
    private int pointer;

    public Queue() {
        container = (T[]) new Comparable[16];
    }

    public Queue(int size) {
        container = (T[]) new Comparable[size];
    }

    public int size() {
        return pointer;
    }

    public void enqueue(T x) {
        if (x == null)
            throw new IllegalArgumentException("Argument cant be null");

        container[pointer++] = x;
    }

    public T dequeue() {
        if (pointer == 0) {
            throw new EmptyQueueException("Not allowed to invoke dequeue on empty queue");
        }

        return container[--pointer];
    }
}
