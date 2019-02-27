package Linkedlist.twoside;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {

    @Test
    public void insert_test(){
        LinkedQueueImpl<Integer> queue = new LinkedQueueImpl<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        Assert.assertThat(queue.size(), Is.is(3));
        Assert.assertThat(queue.peek(), Is.is(1));

    }

    @Test
    public void remove_test(){
        LinkedQueueImpl<Integer> queue = new LinkedQueueImpl<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        Assert.assertThat(queue.size(), Is.is(3));
        Assert.assertThat(queue.remove(), Is.is(1));
        Assert.assertThat(queue.peek(), Is.is(2));

    }
}
