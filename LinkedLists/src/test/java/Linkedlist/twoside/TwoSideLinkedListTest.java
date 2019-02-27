package Linkedlist.twoside;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TwoSideLinkedListTest {

    @Test
    public void insert_any_test(){
        TwoSideLinkedList<Integer> twoSideLinkedList = new TwoSideLinkedListImpl<>();

        twoSideLinkedList.insertLeft(1);
        twoSideLinkedList.insertLeft(2);
        twoSideLinkedList.insertRight(9);
        twoSideLinkedList.insertRight(8);

        Assert.assertThat(twoSideLinkedList.getFirstElement(), Is.is(2));
        Assert.assertThat(twoSideLinkedList.getSize(), Is.is(4));


    }

    @Test
    public void remove_any_test(){
        TwoSideLinkedList<Integer> twoSideLinkedList = new TwoSideLinkedListImpl<>();

        twoSideLinkedList.insertLeft(1);
        twoSideLinkedList.insertLeft(2);
        twoSideLinkedList.insertRight(9);
        twoSideLinkedList.insertRight(8);

        Assert.assertThat(twoSideLinkedList.getSize(), Is.is(4));

        Assert.assertThat(twoSideLinkedList.removeLeft(), Is.is(2));
        Assert.assertThat(twoSideLinkedList.removeLeft(), Is.is(1));

        Assert.assertThat(twoSideLinkedList.remove(8), Is.is(true));
        Assert.assertThat(twoSideLinkedList.getFirstElement(), Is.is(9));




    }
}
