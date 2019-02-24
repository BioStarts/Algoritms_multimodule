package Linkedlist;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void push_test(){

        LinkedStackImpl<Integer> stack = new LinkedStackImpl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertThat(stack.size(), Is.is(3));
        Assert.assertThat(stack.peek(), Is.is(3));
    }

    @Test
    public void remove_test(){

        LinkedStackImpl<Integer> stack = new LinkedStackImpl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertThat(stack.size(), Is.is(3));
        Assert.assertThat(stack.pop(), Is.is(3));

        Assert.assertThat(stack.size(), Is.is(2));
        Assert.assertThat(stack.peek(), Is.is(2));

    }

}
