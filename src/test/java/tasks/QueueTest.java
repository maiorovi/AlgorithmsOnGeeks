package tasks;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tasks.exceptions.EmptyQueueException;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {

    private Queue<Integer> queue;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        queue = new Queue<Integer>();
    }

    @Test
    public void initialSizeOfQueueIs0() {
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    public void whenYouEnqueElementSizeShouldBePlusOne() {
        queue.enqueue(5);

        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    public void fifoOrderIsMaintained() {
        queue.enqueue(5);

        assertThat(queue.dequeue()).isEqualTo(5);
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenNullIsGivenAsArgument() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Argument cant be null");

        queue.enqueue(null);
    }

    @Test
    public void throwExceptionWhenTryToUseDequeueOnEmptyQueue() {
        expectedException.expect(EmptyQueueException.class);
        expectedException.expectMessage("Not allowed to invoke dequeue on empty queue");

        queue.dequeue();
    }

}
