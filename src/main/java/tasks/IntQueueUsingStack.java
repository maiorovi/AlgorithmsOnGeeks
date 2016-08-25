package tasks;

import java.util.Stack;

public class IntQueueUsingStack {

    private Stack<Integer> storage;
    private Stack<Integer> buffer;

    public IntQueueUsingStack() {
        buffer = new Stack<>();
        storage = new Stack<>();
    }

    public void enqueue(Integer value) {
        storage.push(value);
    }

    public Integer dequeue() {
        if (!buffer.isEmpty()) {
            return buffer.pop();
        }

        fillBufferFromStorage(storage, buffer);

        return buffer.pop();
    }

    private void fillBufferFromStorage(Stack<Integer> storage, Stack<Integer> buffer) {
        while(!storage.isEmpty()) {
            buffer.push(storage.pop());
        }
    }


    public static void main(String[] args) {
        IntQueueUsingStack queue = new IntQueueUsingStack();
        queue.enqueue(5);
        System.out.println("Should be 5 = " + queue.dequeue());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }



    }

}
