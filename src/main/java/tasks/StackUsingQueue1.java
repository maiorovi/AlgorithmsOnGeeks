package tasks;

import java.util.LinkedList;
// first variant of stack based on queues with fast push and O(n) pop
public class StackUsingQueue1<T extends Comparable<T>> {

    private LinkedList<T> q1;
    private LinkedList<T> q2;

    public StackUsingQueue1() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(T element) {
        q1.addLast(element);
    }

    public T pop() {
        while(q1.size() != 1) {
            q2.addLast(q1.pollFirst());
        }

        T top =  q1.pollFirst();
        LinkedList<T> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return top;
    }
}
