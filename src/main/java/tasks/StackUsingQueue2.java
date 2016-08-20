package tasks;

import java.util.LinkedList;


// stack with fast pop and slow push operations
public class StackUsingQueue2<T> {

    private LinkedList<T> q1;
    private LinkedList<T> q2;

    public StackUsingQueue2() {
        q1 = new LinkedList<T>();
        q2 = new LinkedList<T>();
    }

    public void push(T elem) {
        if (q1.isEmpty()) {
            q1.addLast(elem);
        } else {
            while(!q1.isEmpty()) {
                q2.addLast(q1.removeFirst());
            }
            q1.addLast(elem);

            while(!q2.isEmpty()) {
                q1.addLast(q2.removeFirst());
            }
        }
    }

    public T pop() {
        return q1.removeFirst();
    }

    public static void main(String[] args){
        StackUsingQueue2 stack = new StackUsingQueue2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.pop();
        System.out.println("\nPeek-Element : "+stack.pop());
//        stack.display();
    }

}
