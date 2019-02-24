package Linkedlist;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class SimpleLinkedTest {

    @Test
    public void insert_test(){
        SimpleLinkedListImpl<Integer> simpleLinkedList = new SimpleLinkedListImpl<>();

        simpleLinkedList.insert(1);
        simpleLinkedList.insert(2);
        simpleLinkedList.insert(3);

        Assert.assertThat(simpleLinkedList.currentSize, Is.is(3));
        Assert.assertThat(simpleLinkedList.getFirstElement(), Is.is(3));

    }

    @Test
    public void remove_test(){
        SimpleLinkedListImpl<Integer> simpleLinkedList = new SimpleLinkedListImpl<>();

        simpleLinkedList.insert(1);
        simpleLinkedList.insert(2);
        simpleLinkedList.insert(3);
        simpleLinkedList.remove();

        Assert.assertThat(simpleLinkedList.currentSize, Is.is(2));
        Assert.assertThat(simpleLinkedList.getFirstElement(), Is.is(2));

    }

    @Test
    public void remove_any_test(){
        SimpleLinkedListImpl<Integer> simpleLinkedList = new SimpleLinkedListImpl<>();

        simpleLinkedList.insert(1);
        simpleLinkedList.insert(2);
        simpleLinkedList.insert(3);
        simpleLinkedList.remove(2);

        Assert.assertThat(simpleLinkedList.currentSize, Is.is(2));
        Assert.assertThat(simpleLinkedList.getFirstElement(), Is.is(3));

    }

}
